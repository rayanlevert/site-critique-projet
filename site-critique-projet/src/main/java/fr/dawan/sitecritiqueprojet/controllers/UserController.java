package fr.dawan.sitecritiqueprojet.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.internal.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.sitecritiqueprojet.beans.Password;
import fr.dawan.sitecritiqueprojet.beans.User;
import fr.dawan.sitecritiqueprojet.dto.UserDto;
import fr.dawan.sitecritiqueprojet.exceptions.EmailExistsException;
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

    @PostMapping(value = "/register")
    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<Object> registerUserAccount(@RequestBody User u) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(u);
        } catch (EmailExistsException ex) {
            return new RestExceptionHandlerController().handleEmailAlreadyExists(ex, u.getEmail());
        }
        return new ResponseEntity<Object>(new ApiResponse(HttpStatus.OK, "L'utilisateur " + registered.getUsername() + "a été créé avec succès!"), HttpStatus.OK);
    }
    
    @PutMapping(value = "/update", produces = "text/plain")
    public String updateUserAccount(@RequestBody User u, HttpServletRequest request, Errors errors) {
        User updated;
        try {
            updated = userService.updateUserAccount(u);
        } catch (EmailExistsException uaeEx) {
            return "User with the email " + u.getEmail() + " already exists";
        }
        return "User" + updated + "has been modified";
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
