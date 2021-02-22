package fr.dawan.sitecritiqueprojet.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.modelmapper.internal.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.sitecritiqueprojet.beans.Password;
import fr.dawan.sitecritiqueprojet.beans.User;
import fr.dawan.sitecritiqueprojet.dto.UserDto;
import fr.dawan.sitecritiqueprojet.exceptions.EmailExistsException;
import fr.dawan.sitecritiqueprojet.exceptions.UsernameExistsException;
import fr.dawan.sitecritiqueprojet.response.ApiResponse;
import fr.dawan.sitecritiqueprojet.services.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    public UserDetailsService userDetailsService;
    
    @GetMapping(value = "/getAll", produces = "application/json")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping(value = "/{id}")
    public UserDto getById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/getByUsername", produces = "application/json")
    public ResponseEntity<Object> getByUsername(@RequestParam String username) {
        UserDto searched = null;
        try {
            searched = userService.getUserByUsername(username);
        } catch (UsernameExistsException ex) {
            return new RestExceptionHandlerController().handleUsernameAlreadyExists(ex, username);
        }
        return new ResponseEntity<Object>(new ApiResponse(HttpStatus.OK, "L'utilisateur " + searched.getUsername() + "existe bien!", searched), HttpStatus.OK); 
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Object> registerUserAccount(@RequestBody User u) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(u);
        } catch (EmailExistsException ex) {
            return new RestExceptionHandlerController().handleEmailAlreadyExists(ex, u.getEmail());
        } catch (UsernameExistsException ex) {
            return new RestExceptionHandlerController().handleUsernameAlreadyExists(ex, u.getUsername());
        } catch (ConstraintViolationException ex) {
            return new RestExceptionHandlerController().handleViolationException(ex);
        }
        return new ResponseEntity<Object>(new ApiResponse(HttpStatus.OK, "L'utilisateur " + registered.getUsername() + " a été créé avec succès!", registered), HttpStatus.OK);
    }
    
    @PutMapping(value = "/update")
    public ResponseEntity<Object> updateUserAccount(@RequestBody User u, HttpServletRequest request, Errors errors) {
        User updated;
        try {
            updated = userService.updateUserAccount(u);
        } catch (UsernameExistsException ex) {
            return new RestExceptionHandlerController().handleUsernameAlreadyExists(ex, u.getUsername());
        } catch (EmailExistsException ex) {
            return new RestExceptionHandlerController().handleEmailAlreadyExists(ex, u.getEmail());
        } catch (ConstraintViolationException ex) {
            return new RestExceptionHandlerController().handleViolationException(ex);
        }
        return new ResponseEntity<Object>(new ApiResponse(HttpStatus.OK, "Votre profil " + updated.getUsername() + " a été modifié avec succès!", updated), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> deleteUserAccount(@PathVariable long id) {
        UserDto deleted = userService.deleteUserById(id);
        return new ResponseEntity<Object>(new ApiResponse(HttpStatus.OK, "L'utilisateur " + deleted.getUsername() + " a été supprimé avec succès!"), HttpStatus.OK);
    }

    @PostMapping(value = "/checkPassword")
    public ResponseEntity<Object> checkPassword(@RequestBody Password p) {
        boolean check = userService.passwordCheck(p.getRawPassword(), p.getEncodedPassword());
        if (check) {
            return new ResponseEntity<Object>(new ApiResponse(HttpStatus.OK, "Mot de passe vérifié avec succès"), HttpStatus.OK);
        } else return new ResponseEntity<Object>(new ApiResponse(HttpStatus.CONFLICT, "Mot de passe incorrect"), HttpStatus.CONFLICT);
    }

    @PostMapping(value="/authenticate")
    public ResponseEntity<Object> authenticate(@RequestBody User u) {
        UserDto authenticated = null;
        
        try {
            authenticated = userService.loadByUsernameAndPassword(u.getUsername(), u.getPassword());
            System.out.println(authenticated);
        } catch (UsernameNotFoundException e) {
            return new RestExceptionHandlerController().handleUsernameNotFound(e, u.getUsername());
        }
        return new ResponseEntity<Object>(new ApiResponse(HttpStatus.OK, "La connexion a réussi", authenticated), HttpStatus.OK);
    }
}
