package ru.maxima.dao;

import org.springframework.stereotype.Component;
import ru.maxima.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Ivanov Ivan", 1995));
        people.add(new Person(++PEOPLE_COUNT, "Petrov Ivan", 1980));
        people.add(new Person(++PEOPLE_COUNT, "Sidorov Grisha", 1953));
        people.add(new Person(++PEOPLE_COUNT, "Pushkin Alexandr", 2000));
    }

    public List<Person> index() {
        return people;
    }

    public Person showPerson(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void savePerson(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void updatePerson(int id, Person updatePerson) {
        Person personToBeUpdated = showPerson(id);
        personToBeUpdated.setFullName(updatePerson.getFullName());
        personToBeUpdated.setYearOfBirth(updatePerson.getYearOfBirth());
    }

    public void deletePerson(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
