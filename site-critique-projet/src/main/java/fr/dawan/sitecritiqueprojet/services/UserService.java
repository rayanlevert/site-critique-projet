package fr.dawan.sitecritiqueprojet.services;

import java.util.List;

import fr.dawan.sitecritiqueprojet.beans.User;
import fr.dawan.sitecritiqueprojet.exceptions.EmailExistsException;

public interface UserService {
    
    List<User> getAllUsers();
    User registerNewUserAccount(User u) throws EmailExistsException;
    boolean emailExist(String email);

}
