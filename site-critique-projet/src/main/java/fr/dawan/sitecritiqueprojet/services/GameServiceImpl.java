package fr.dawan.sitecritiqueprojet.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.sitecritiqueprojet.beans.Game;

import fr.dawan.sitecritiqueprojet.repositories.GameRepository;

@Service
@Transactional
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;
    @Override
    public List<Game> findAll() {
        try {
            Iterable<Game> games = gameRepository.findAll();
            if(((List<Game>) games).isEmpty())
            {
                System.out.println("Aucun jeu disponible");
                return null;
            }
            else {
                return (List<Game>) games; 
            }       
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération des jeux");
            return null;
        }   
    }
    @Override
    public Game findOneById(long id)
    {
        Game game;
        
        try {
            Optional<Game> gameOpt = gameRepository.findById(id);
            game = gameOpt.get();
        } catch (Exception e) {
            e.printStackTrace();
            game = null;
        }
        return game;
    }
    @Override
    public Game saveOrUpdate(Game game) {
        gameRepository.saveAndFlush(game);
        return game;
    }
    @Override
    public boolean deleteById(long id) {
        try {
           gameRepository.deleteById(id);
           return true; 
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    @Override
    public boolean deleteAllById(List<Long> id) {
        try {
            for (long i : id) {
                gameRepository.deleteById(i);
            };
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public List<Game> findBySearchFiltered(String search, String filter, String filterValue) {
        List<Game> game = null;
        try {
            switch (filter) {
            case "genre": game = gameRepository.searchByGenre(search, filterValue);
                break;
            case "developer": game = gameRepository.searchByDev(search, filterValue);
                break;
            case "publisher": game = gameRepository.searchByPublisher(search, filterValue);
                break;
            case "platform": game = gameRepository.searchByPlatform(search, filterValue);
                break;
            default:
                game = gameRepository.searchByAll(search);
                break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return game;
    }
    @Override
    public List<Game> findByFilter(String filter, String filterValue) {
        List<Game> game = null;
        try {
            switch (filter) {
            case "genre": game = gameRepository.findByGenre(filterValue);
                break;
            case "developer": game = gameRepository.findByDev(filterValue);
                break;
            case "publisher": game = gameRepository.findByPublisher(filterValue);
                break;
            case "platform": game = gameRepository.findByPlatform(filterValue);
                break;
            default:
                game = gameRepository.findAll();
                break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return game;
    }
    @Override
    public List<Game> findBySearch(String search) {
        List<Game> game = null;
        try {
            game = gameRepository.searchByAll(search);
            }
        catch (Exception e) {
            e.printStackTrace();
        }
        return game;
    }
    
    @Override
    public List<Game> findAll(int page, int i) {
        List<Game> games = null;
        try {
            games = gameRepository.findAll(PageRequest.of(page, i)).get().collect(Collectors.toList());
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        return games;
    }
}
