package ru.maxima.dao;

import org.springframework.stereotype.Component;
import ru.maxima.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAO {
    private static int BOOKS_COUNT;
    private List<Book> books;

    {
        books = new ArrayList<>();
        books.add(new Book(++BOOKS_COUNT, "Book1", "Pushkin", 1885));
        books.add(new Book(++BOOKS_COUNT, "Book2", "Esenin", 1755));
        books.add(new Book(++BOOKS_COUNT, "Book3", "Tolstoy", 1665));
        books.add(new Book(++BOOKS_COUNT, "Book4", "Gogol", 1155));
    }

    public List<Book> index() {
        return books;
    }

    public Book showBook(int id) {
        return books.stream().filter(book -> book.getId() == id).findAny().orElse(null);
    }

    public void saveBook(Book book) {
        book.setId(++BOOKS_COUNT);
        books.add(book);
    }

    public void updateBook(int id, Book updateBook) {
        Book bookToBeUpdated = showBook(id);
        bookToBeUpdated.setAuthorOfBook(updateBook.getAuthorOfBook());
        bookToBeUpdated.setNameOfBook(updateBook.getNameOfBook());
        bookToBeUpdated.setYearOfWritingBook(updateBook.getYearOfWritingBook());
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
