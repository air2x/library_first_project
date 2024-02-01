package ru.maxima.model;


import jakarta.validation.constraints.NotEmpty;

public class Book {
    @NotEmpty(message = "Name of book should not be empty")
    private String nameOfBook;
    @NotEmpty(message = "Author of book should not be empty")
    private String authorOfBook;
    @NotEmpty(message = "Year of wright book should not be empty")
    private int yearOfWritingBook;

    public Book(String nameOfBook, String authorOfBook, int yearOfWritingBook) {
        this.nameOfBook = nameOfBook;
        this.authorOfBook = authorOfBook;
        this.yearOfWritingBook = yearOfWritingBook;
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
}
