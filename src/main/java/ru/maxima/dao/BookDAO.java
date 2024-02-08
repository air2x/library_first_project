package ru.maxima.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.maxima.model.Book;
import ru.maxima.model.BookMapper;


import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> showAllBooks() {
        return jdbcTemplate.query("SELECT * FROM Book", new BookMapper());
    }

    public Book showBook(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id},
                        new BookMapper())
                .stream().findAny().orElse(null);
    }

    public void saveBook(Book book) {
        jdbcTemplate.update("INSERT INTO Book(name_of_book, author_of_book, year_of_writing_book) VALUES(?, ?, ?)",
                book.getNameOfBook(), book.getAuthorOfBook(), book.getYearOfWritingBook());

    }

    public void updateBook(int id, Book updateBook) {
        jdbcTemplate.update("UPDATE Book SET name_of_book=?, author_of_book=?, year_of_writing_book=? WHERE id=?",
                updateBook.getNameOfBook(), updateBook.getAuthorOfBook(), updateBook.getYearOfWritingBook(), id);
    }

    public void deleteBook(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }
}
