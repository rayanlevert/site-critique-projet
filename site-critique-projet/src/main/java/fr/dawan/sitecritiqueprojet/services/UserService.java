package fr.dawan.sitecritiqueprojet.services;

import java.util.List;

import fr.dawan.sitecritiqueprojet.beans.User;
import fr.dawan.sitecritiqueprojet.dto.UserDto;
import fr.dawan.sitecritiqueprojet.exceptions.EmailExistsException;

public interface UserService {
    
    List<UserDto> getAllUsers();
    UserDto getUserById(long id);
    User registerNewUserAccount(User u) throws EmailExistsException;
    User updateUserAccount(User u) throws EmailExistsException;
    boolean emailExist(User user);

}
