package fr.dawan.sitecritiqueprojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.sitecritiqueprojet.beans.Article;
import fr.dawan.sitecritiqueprojet.beans.Book;
import fr.dawan.sitecritiqueprojet.beans.Game;
import fr.dawan.sitecritiqueprojet.beans.Movie;
import fr.dawan.sitecritiqueprojet.beans.Search;
import fr.dawan.sitecritiqueprojet.services.BookService;
import fr.dawan.sitecritiqueprojet.services.GameService;
import fr.dawan.sitecritiqueprojet.services.MovieService;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    
    
    //déclaration des repositories
    
    @Autowired
    private MovieService iMovieService;
    @Autowired
    private GameService iGameService;
    @Autowired 
    private BookService iBookService;
    
    
    /*
     * getPage(int[] data) => renvoie un objet Search contenant des listes d'objets
     * ["page","size"] => [0,15]
     * "page" indique la page souhaité, démarre à 0
     * "size" indique le nombre d'objet à récupérer pour chaque type d'objet
     * [0,10] => valeur par défaut si data = null
     * [0,10] cible la page 0 qui contiendra : 10 objets Movie, 10 objets Game, 10 objets Book
     * */
    @PostMapping(value = "/page", consumes = "application/json", produces = "application/json")
    public Search getPage( @RequestBody int[] data)
    {
        //traitement du tableau POST
        int page,size;
        if(data == null)
        {
            page = 0;
            size = 10;
        }
        else {
          page = data[0];
          size = data[1];  
        }
        Search res = null;
        List<Movie> movies = iMovieService.findAll(page,size);
        List<Game> games = iGameService.findAll(page,size);
        List<Book> books = iBookService.findAll(page,size);
        res = new Search(movies, games, books);
        return res; 
    }

}
