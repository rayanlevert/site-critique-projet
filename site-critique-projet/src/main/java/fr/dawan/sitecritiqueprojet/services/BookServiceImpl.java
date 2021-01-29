package fr.dawan.sitecritiqueprojet.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.sitecritiqueprojet.beans.Book;
import fr.dawan.sitecritiqueprojet.repositories.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()) {
            return book.get();
        } else return null;
    }

    @Override
    public Book saveOrUpdate(Book b) {
        bookRepository.saveAndFlush(b);
        return b;
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

}
