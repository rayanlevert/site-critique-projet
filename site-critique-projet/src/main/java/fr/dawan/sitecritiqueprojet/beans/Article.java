package fr.dawan.sitecritiqueprojet.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="article")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminator", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name="title", length=255, nullable=false)
    private String title;
    
    @OneToMany(targetEntity=Review.class, mappedBy="article")
    private List<Review> reviews;
    
}
