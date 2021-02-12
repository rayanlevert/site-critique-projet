package fr.dawan.sitecritiqueprojet.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.internal.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.sitecritiqueprojet.beans.User;
import fr.dawan.sitecritiqueprojet.dto.UserDto;
import fr.dawan.sitecritiqueprojet.exceptions.EmailExistsException;
import fr.dawan.sitecritiqueprojet.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UserService userService;
    
    @GetMapping(value = "/getAll", produces = "application/json")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping(value = "/{id}")
    public UserDto getById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    public String registerUserAccount(@RequestBody User u, HttpServletRequest request,
            Errors errors) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(u);
        } catch (EmailExistsException uaeEx) {
            return "User already exists";
        }
        return "User " + registered + "has been created";
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
}
