package fr.dawan.sitecritiqueprojet.beans;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import org.hibernate.annotations.Type;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "civilite", length = 255, nullable = false)
    private String civilite;
    
    @Column(name = "username", length = 255, nullable = false)
    private String username;
    
    @Column(name = "lastname", length = 255, nullable = false)
    private String lastname;
    
    @Column(name = "firstname", length = 255, nullable = false)
    private String firstname;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "registration_date")
    private String registrationDate;

    @Column(name = "description", length = 65535, nullable = true)
    @Type(type = "text")
    private String description;

    @Column(name = "catch_phrase", length = 1000, nullable = true)
    private String catchPhrase;
    
    @Column(name = "password", length = 255, nullable = false)
    private String password;
    
    @Column(name = "email", length = 255, nullable = false, unique = true)
    @Email(message = "L'email doit être une adresse éléctronique syntaxiquement correcte.")
    private String email;
    
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", civilite='" + getCivilite() + "'" +
            ", username='" + getUsername() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", firstname='" + getFirstname() + "'" +
            ", age='" + getAge() + "'" +
            ", registrationDate='" + getRegistrationDate() + "'" +
            ", description='" + getDescription() + "'" +
            ", catchPhrase='" + getCatchPhrase() + "'" +
            ", password='" + getPassword() + "'" +
            ", email='" + getEmail() + "'" +
            ", roles='" + getRoles() + "'" +
            ", comments='" + getComments() + "'" +
            ", reviews='" + getReviews() + "'" +
            "}";
    }
    
}
