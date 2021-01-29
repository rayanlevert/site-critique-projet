package fr.dawan.sitecritiqueprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.sitecritiqueprojet.beans.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
    @Query("FROM Role r WHERE r.name = :name")
    Role findByName(@Param("name") String name);

}
