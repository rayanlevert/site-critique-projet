package fr.dawan.sitecritiqueprojet.beans;

import java.util.Date;
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
@Inheritance( strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="discriminator", discriminatorType = DiscriminatorType.STRING)

/*
 * Liste des enfants :
 * Book, Movie, Game
 */
public abstract class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name="title", length=255, nullable=false)
    private String title;
    
    @OneToMany(targetEntity=Review.class, mappedBy="article")
    private List<Review> reviews;
    
    @Column(name="publishDate", nullable=false) //date de sortie mondiale du film,jeu,livre -> article
    private Date publishDate;
    @Column(name="creationArticleDate") //date de publication sur le site
    private Date creationArticleDate;
    
    @Column(name="minAge")
    private int minAge;
    
    @Column(name="valid")
    private boolean valid;
    
    //Constructors
    
    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Article(long id, String title, List<Review> reviews, Date publishDate, Date creationArticleDate, int minAge, boolean valid) {
        super();
        this.id = id;
        this.title = title;
        this.reviews = reviews;
        this.publishDate = publishDate;
        this.creationArticleDate = creationArticleDate;
        this.minAge = minAge;
        this.valid = valid;
    }
    
    public Article() {
        super();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getCreationArticleDate() {
        return creationArticleDate;
    }

    public void setCreationArticleDate(Date creationArticleDate) {
        this.creationArticleDate = creationArticleDate;
    }

    
    
    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    
    
    
}
