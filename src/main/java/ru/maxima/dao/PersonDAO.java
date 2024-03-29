package ru.maxima.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.maxima.model.Book;
import ru.maxima.model.BookMapper;
import ru.maxima.model.Person;
import ru.maxima.model.PersonMapper;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> showAllPeople() {
        return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());
    }

    public Optional<Person> showPerson(String fullName) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE full_name=?", new Object[]{fullName},
                new PersonMapper()).stream().findAny();
    }

    public Person showPerson(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},
                        new PersonMapper())
                .stream().findAny().orElse(null);
    }

    public void savePerson(Person person) {
        jdbcTemplate.update("INSERT INTO Person(full_name, year_of_birth) VALUES(?, ?)", person.getFullName(),
                person.getYearOfBirth());
    }

    public void updatePerson(int id, Person updatePerson) {
        jdbcTemplate.update("UPDATE Person SET full_name=?, year_of_birth=? WHERE id=?", updatePerson.getFullName(),
                updatePerson.getYearOfBirth(), id);
    }

    public void deletePerson(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    public List<Book> showBooksOnTheHands(int id) {
        return jdbcTemplate.query("SELECT * FROM Book JOIN Person P on P.id = Book.person_id WHERE person_id=?",
                new Object[]{id}, new BookMapper());
    }
}
