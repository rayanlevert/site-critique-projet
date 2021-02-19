package fr.dawan.sitecritiqueprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.sitecritiqueprojet.beans.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    @Query("FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);

    @Query("FROM User u WHERE u.username = :username")
    User findByUsername(@Param("username") String username);

}
