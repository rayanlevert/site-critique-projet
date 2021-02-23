package fr.dawan.sitecritiqueprojet.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.dawan.sitecritiqueprojet.beans.Privilege;
import fr.dawan.sitecritiqueprojet.beans.Role;
import fr.dawan.sitecritiqueprojet.beans.User;
import fr.dawan.sitecritiqueprojet.dto.UserDto;
import fr.dawan.sitecritiqueprojet.exceptions.EmailExistsException;
import fr.dawan.sitecritiqueprojet.exceptions.UsernameExistsException;
import fr.dawan.sitecritiqueprojet.repositories.RoleRepository;
import fr.dawan.sitecritiqueprojet.repositories.UserRepository;

@Service("userDetailsService")
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private Validator validator;

    @Override
    public UserDto loadByUsernameAndPassword(String username, String password) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        System.out.println(user);
        if (user != null) {
            boolean check = passwordCheck(password, user.getPassword());
            if (check) {
                System.out.println(user);
                return getUserById(user.getId());
            }
            throw new UsernameNotFoundException(
                    "Un utilisateur avec le pseudo '" + username + "' n'existe pas ou le mot de passe est incorrect");
        } else {
            throw new UsernameNotFoundException(
                    "Un utilisateur avec le pseudo '" + username + "' n'existe pas ou le mot de passe est incorrect");
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {

        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    @Override
    public User registerNewUserAccount(User u) throws EmailExistsException, UsernameExistsException, ConstraintViolationException {
        if (emailExist(u)) {
            throw new EmailExistsException("There is an account with that email adress: " + u.getEmail());
        }

        if (usernameExist(u)) {
            throw new UsernameExistsException("Il y a déjà un utilisateur avec ce pseudonyme: " + u.getUsername());
        }

        User user = new User();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        user.setFirstname(u.getFirstname());
        user.setLastname(u.getLastname());
        user.setPassword(passwordEncoder.encode(u.getPassword()));
        user.setEmail(u.getEmail());
        user.setUsername(u.getUsername());
        user.setRegistrationDate(new Date());
        user.setLastConnection(dateFormat.format(new Date()));
        user.setAge(u.getAge());
        user.setCivilite(u.getCivilite());
        user.setDescription(u.getDescription());
        user.setCatchPhrase(u.getCatchPhrase());
        
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        List<Role> roles = new ArrayList<Role>();
        if (u.getRoles() != null) {
            for (Role role : u.getRoles()) {
                roles.add(roleRepository.findByName(role.getName()));
            }
        }
        roles.add(roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);

        return userRepository.save(user);
    }

    @Override
    public User updateUserAccount(User u) throws EmailExistsException, UsernameExistsException {
        boolean checkPassword = hasPasswordBeenModified(u.getId(), u.getPassword());

        if (emailExist(u)) {
            throw new EmailExistsException("There is an account with that email adress: " + u.getEmail());
        }

        if (usernameExist(u)) {
            throw new UsernameExistsException("Il y a déjà un utilisateur avec ce pseudonyme: " + u.getUsername());
        }

        if (checkPassword) {
            u.setPassword(passwordEncoder.encode(u.getPassword()));
        }

        Set<ConstraintViolation<User>> violations = validator.validate(u);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        
        List<Role> roles = new ArrayList<Role>();
        if (u.getRoles() != null) {
            for (Role role : u.getRoles()) {
                roles.add(roleRepository.findByName(role.getName()));
            }
        }
        u.setRoles(roles);

        return userRepository.saveAndFlush(u);
    }

    @Override
    public UserDto getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        ModelMapper m = new ModelMapper();
        if (user.isPresent()) {
            return m.map(user.get(), UserDto.class);
        } else
            return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<UserDto>();
        ModelMapper m = new ModelMapper();

        for (User u : users) {
            usersDto.add(m.map(u, UserDto.class));
        }
        return usersDto;
    }

    @Override
    public boolean emailExist(User user) {
        List<User> users = userRepository.findAll();
        for (User u : users) {
            if (u.getEmail().equals(user.getEmail()) && u.getId() != user.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean usernameExist(User user) {
        List<User> users = userRepository.findAll();
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername()) && u.getId() != user.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPasswordBeenModified(long id, String password) {
        UserDto u = getUserById(id);
        if (password.equals(u.getPassword())) {
            return false;
        }
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public boolean passwordCheck(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public UserDto deleteUserById(long id) {
        UserDto u = getUserById(id);
        userRepository.deleteById(id);
        return u;
    }

    @Override
    public UserDto getUserByUsername(String username) throws UsernameExistsException {
        ModelMapper m = new ModelMapper();
        return m.map(userRepository.findByUsername(username), UserDto.class);
    }
}