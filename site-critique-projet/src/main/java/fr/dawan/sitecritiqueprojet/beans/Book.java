package fr.dawan.sitecritiqueprojet.beans;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("book")
public class Book extends Article {
    @Column(name = "author", nullable = false)
    private String author;
    
    @Column(name = "genre", nullable = false)
    private String genre;

    public Book() {
        super();
    }

    public Book(String author, String genre) {
        super();
        this.author = author;
        this.genre = genre;
    }
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenreBooks(String genre) {
        this.genre = genre;
    }    
}
