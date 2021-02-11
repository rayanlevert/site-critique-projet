package fr.dawan.sitecritiqueprojet.beans;

import java.util.List;

public class Search {
    List<Movie> movies;
    List<Game> games;
    List<Book> books;
    public List<Movie> getMovies() {
        return movies;
    }
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    public List<Game> getGames() {
        return games;
    }
    public void setGames(List<Game> games) {
        this.games = games;
    }
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public Search(List<Movie> movies, List<Game> games, List<Book> books) {
        this.movies = movies;
        this.games = games;
        this.books = books;
    }
    public Search() {
        this.movies = null;
        this.games = null;
        this.books = null;
    }
    
    
}
