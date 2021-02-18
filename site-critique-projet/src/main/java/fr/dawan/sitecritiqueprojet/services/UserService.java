package fr.dawan.sitecritiqueprojet.services;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.dawan.sitecritiqueprojet.beans.User;
import fr.dawan.sitecritiqueprojet.dto.UserDto;
import fr.dawan.sitecritiqueprojet.exceptions.EmailExistsException;
import fr.dawan.sitecritiqueprojet.exceptions.UsernameExistsException;

public interface UserService {
    
    List<UserDto> getAllUsers();
    UserDto getUserById(long id);
    User registerNewUserAccount(User u) throws EmailExistsException, UsernameExistsException;
    User updateUserAccount(User u) throws EmailExistsException;
    boolean passwordCheck(String rawPassword, String encodedPassword);
    boolean emailExist(User user);
    UserDto loadByUsernameAndPassword(String username, String password) throws UsernameNotFoundException;
    UserDto deleteUserById(long id);

}
