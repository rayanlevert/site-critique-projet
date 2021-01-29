package fr.dawan.sitecritiqueprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.sitecritiqueprojet.beans.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long>{
    
    @Query("FROM Privilege p WHERE p.name = :name")
    Privilege findByName(@Param("name") String name);

}
