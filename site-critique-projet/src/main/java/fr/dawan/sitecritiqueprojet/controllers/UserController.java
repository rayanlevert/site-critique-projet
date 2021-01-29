package fr.dawan.sitecritiqueprojet.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.internal.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.sitecritiqueprojet.beans.User;
import fr.dawan.sitecritiqueprojet.exceptions.EmailExistsException;
import fr.dawan.sitecritiqueprojet.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;
    
    @GetMapping(value = "/getAll", produces = "application/json")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
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
}
