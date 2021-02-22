package fr.dawan.sitecritiqueprojet.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "username", length = 255, nullable = false)
    private String username;
    
    @Column(name = "lastname", length = 255, nullable = false)
    private String lastname;
    
    @Column(name = "firstname", length = 255, nullable = false)
    private String firstname;
    
    @Column(name = "password", length = 255, nullable = false)
    private String password;
    
    @Column(name = "email", length = 255, nullable = false, unique = true)
    @Email
    private String email;
    
    @Column(name = "enabled")
    private boolean enabled;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "role_users", 
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Commentary> comments;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;
    
    public User() {
	}

	// Constructor with id
    public User(long id, String username, String lastname, String firstname, String password) {
        this.id = id;
        this.username = username;
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
    }

    // Constructor without id
    public User(String username, String lastname, String firstname, String password) {
        this.username = username;
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
    }

    public User(long id, List<Role> roles) {
        this.id = id;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Commentary> getComments() {
        return comments;
    }

    public void setComments(List<Commentary> comments) {
        this.comments = comments;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", lastname=" + lastname + ", firstname=" + firstname
                + ", password=" + password + ", email=" + email + ", enabled=" + enabled + ", roles=" + roles
                + ", comments=" + comments + ", reviews=" + reviews + "]";
    }
}
