package fr.dawan.sitecritiqueprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.sitecritiqueprojet.beans.Commentary;
@Repository
public interface ReviewRepository extends JpaRepository<Commentary, Long> {

}
