package ru.maxima.dao;

import ru.maxima.model.Book;
import ru.maxima.model.Person;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static int BOOKS_COUNT;
    private List<Book> books;

    {
        books = new ArrayList<>();
        books.add(new Book("Book1", "Pushkin A.S", 1885));
    }

    public List<Book> index() {
        return books;
    }

    public Book show(int id) {
        return books.stream().filter(b -> b.getId() == id).findAny().orElse(null);
    }

    public void save(Book book) {
        book.setId(++BOOKS_COUNT);
        books.add(book);
    }

    public void update(int id, Book updateBook) {
        Book bookToBeUpdated = show(id);
        bookToBeUpdated.setAuthorOfBook(updateBook.getAuthorOfBook());
        bookToBeUpdated.setNameOfBook(updateBook.getNameOfBook());
        bookToBeUpdated.setYearOfWritingBook(updateBook.getYearOfWritingBook());
    }

    public void delete(int id) {
        books.removeIf(b -> b.getId() == id);
    }
}
