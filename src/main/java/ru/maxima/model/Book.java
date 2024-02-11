package ru.maxima.model;


import jakarta.validation.constraints.NotEmpty;

public class Book {
    private int id;
    @NotEmpty(message = "Назавние не должно быть пустым")
    private String nameOfBook;
    @NotEmpty(message = "Автор не должен быть пустым")
    private String authorOfBook;
    private int yearOfWritingBook;
    private int personId;

    public Book() {
    }

    public Book(int id, String nameOfBook, String authorOfBook, int yearOfWritingBook, int personId) {
        this.id = id;
        this.nameOfBook = nameOfBook;
        this.authorOfBook = authorOfBook;
        this.yearOfWritingBook = yearOfWritingBook;
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getAuthorOfBook() {
        return authorOfBook;
    }

    public void setAuthorOfBook(String authorOfBook) {
        this.authorOfBook = authorOfBook;
    }

    public int getYearOfWritingBook() {
        return yearOfWritingBook;
    }

    public void setYearOfWritingBook(int yearOfWritingBook) {
        this.yearOfWritingBook = yearOfWritingBook;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
