package fr.dawan.sitecritiqueprojet.beans;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class Book extends Article {
    @Column(name = "author", nullable = false)
    private String author;
    
    @Column(name = "genreBooks", nullable = false)
    private String genreBooks;

    public Book() {
        super();
    }

    public Book(String author, String genreBooks) {
        super();
        this.author = author;
        this.genreBooks = genreBooks;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenreBooks() {
        return genreBooks;
    }

    public void setGenreBooks(String genreBooks) {
        this.genreBooks = genreBooks;
    }    
}
