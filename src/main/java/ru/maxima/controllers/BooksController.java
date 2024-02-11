package ru.maxima.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.maxima.dao.BookDAO;
import ru.maxima.dao.PersonDAO;
import ru.maxima.model.Book;
import ru.maxima.model.Person;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookDAO bookDAO;
    private final PersonDAO personDAO;

    @Autowired
    public BooksController(BookDAO bookDAO, PersonDAO personDAO) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }

    @GetMapping
    public String showAllBooks(Model model) {
        model.addAttribute("books", bookDAO.showAllBooks());
        return "view-with-all-books";
    }

    @PatchMapping("/{id}/assign")
    public String assignABook(@PathVariable("id") int id, Model model,
                              @ModelAttribute("person") Person person) {
        bookDAO.assignABook(id, person);

        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String showBook(@PathVariable("id") int id, Model model,
                           @ModelAttribute("person") Person person) {
        model.addAttribute("book", bookDAO.showBook(id));
        model.addAttribute("people", personDAO.showAllPeople());
        model.addAttribute("whoHasTheBook", bookDAO.showsWhoHasTheBook(id));
        return "view-with-book-by-id";
    }
    @PatchMapping("/{id}/freeTheBook")
    public String freeTheBook(@PathVariable("id") int id) {
        bookDAO.freeTheBook(id);
        return "redirect:/books";
    }

    @GetMapping("/new")
    public String addNewBook(Model model) {
        model.addAttribute("book", new Book());
        return "view-to-create-new-book";
    }

    @PostMapping()
    public String createBook(@ModelAttribute("book") @Valid Book book,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "view-to-create-new-book";
        }
        bookDAO.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String editBook(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookDAO.showBook(id));
        return "view-to-edit-book";
    }

    @PatchMapping("/{id}")
    public String updateBook(@ModelAttribute("book") @Valid Book book,
                             BindingResult bindingResult,
                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "view-to-edit-book";
        }
        bookDAO.updateBook(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookDAO.deleteBook(id);
        return "redirect:/books";
    }
}
