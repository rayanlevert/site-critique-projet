package fr.dawan.sitecritiqueprojet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.sitecritiqueprojet.beans.Book;
import fr.dawan.sitecritiqueprojet.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @GetMapping(value = "/getAll", produces = "application/json")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    
    @GetMapping(value = "{id}", produces = "application/json")
    public Book getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Book save(@RequestBody Book b) {
        return bookService.saveOrUpdate(b);
    }
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    public Book update(@RequestBody Book b) {
        return bookService.saveOrUpdate(b);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable long id) {
        bookService.deleteById(id);
    }

}
