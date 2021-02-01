package fr.dawan.sitecritiqueprojet.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.dawan.sitecritiqueprojet.beans.Privilege;
import fr.dawan.sitecritiqueprojet.beans.Role;
import fr.dawan.sitecritiqueprojet.beans.User;
import fr.dawan.sitecritiqueprojet.exceptions.EmailExistsException;
import fr.dawan.sitecritiqueprojet.repositories.RoleRepository;
import fr.dawan.sitecritiqueprojet.repositories.UserRepository;

@Service("userDetailsService")
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageSource messages;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if (user == null) {
            return new org.springframework.security.core.userdetails.User(" ", " ", true, true, true, true,
                    getAuthorities(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                user.isEnabled(), true, true, true, getAuthorities(user.getRoles()));
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
    public User registerNewUserAccount(User u) throws EmailExistsException {
        PasswordEncoder pe = new BCryptPasswordEncoder();

        if (emailExist(u)) {
            throw new EmailExistsException("There is an account with that email adress: " + u.getEmail());
        }
        User user = new User();

        user.setFirstname(u.getFirstname());
        user.setLastname(u.getLastname());
        user.setPassword(pe.encode(u.getPassword()));
        user.setEmail(u.getEmail());
        user.setUsername(u.getUsername());

        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public User updateUserAccount(User u) throws EmailExistsException {
        System.out.println(u);
        if (emailExist(u)) {
            throw new EmailExistsException("There is an account with that email adress: " + u.getEmail());
        }
        return userRepository.saveAndFlush(u);
    }

    @Override
    public User getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else
            return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
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
}