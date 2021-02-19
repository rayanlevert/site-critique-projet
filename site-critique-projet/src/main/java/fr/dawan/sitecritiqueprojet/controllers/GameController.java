package fr.dawan.sitecritiqueprojet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.sitecritiqueprojet.beans.Game;
import fr.dawan.sitecritiqueprojet.services.GameService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService iGameService;
    
    @GetMapping("/")
    public List<Game> getGames()
    {
        List<Game> games = iGameService.findAll();
        return games;
    }
    
    @GetMapping("/{id}")
    public Game getGame(@PathVariable("id") long id)
    {
        Game game = iGameService.findOneById(id);
        return game;
    }
    
    
    /*
     * [search,filter,filterValue] recherche avec filtre -->findBySearchFiltered
     * [search,"",""] recherche sans filtres -->findBySearch
     * ["",filter,filterValue] filtrage des jeux sur une propriété -->findByFilter
     * filter & filterValue doivent être avoir tout deux une valeur ou être null
     * */
    @PostMapping(value = "/search", consumes="application/json", produces="application/json")
    public List<Game> getSearchGames(@RequestBody List<String> data)
    {
        List<Game> games = null;
        String search = data.get(0);
        String filter = data.get(1);
        String filterValue = data.get(2);
        if(search != "" && filter != "" && filterValue != "")
        {
            games = iGameService.findBySearchFiltered(search,filter, filterValue);
        }
        else if(search == "" && filter != "" && filterValue != "")
        {
            games = iGameService.findByFilter(filter, filterValue);
        }
        else if(search != "" && filter == "" && filterValue == "")
        {
            games = iGameService.findBySearch(search);
        }
        else {
            games = iGameService.findAll();
        }
        return games;        
    }    
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Game createGame( @RequestBody Game game )
    {
        Game createdGame = iGameService.saveOrUpdate(game);
        return createdGame;
    }
    
    @PutMapping(consumes="application/json", produces="application/json")
    public Game updateGame( @RequestBody Game game )
    {
        Game updatedGame = iGameService.saveOrUpdate(game);
        return updatedGame;
    }
    
    @DeleteMapping(value="/{id}")
    public void deleteGame( @PathVariable long id )
    {
        iGameService.deleteById(id);
    }
    
    @PostMapping(value = "/multiple",consumes = "application/json", produces = "application/json")
    public void deleteMultipleGames( @RequestBody List<Long> id )
    {
        iGameService.deleteAllById(id);
    }
}
