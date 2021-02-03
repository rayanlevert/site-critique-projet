package fr.dawan.sitecritiqueprojet.services;

import java.util.List;

import fr.dawan.sitecritiqueprojet.beans.Book;

public interface BookService {
    //pagination
    public List<Book> findAll(int page, int i);

    public List<Book> getAllBooks();
    public Book getBookById(long id);
    
    /* CRUD */
    public Book saveOrUpdate(Book b);
    public void deleteById(long id);
    //fonction deleteAllById à développer
    
    
}
