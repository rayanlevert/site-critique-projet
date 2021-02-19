package fr.dawan.sitecritiqueprojet.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="article")
@Inheritance( strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="discriminator", discriminatorType = DiscriminatorType.STRING)

/*
 * Liste des enfants :
 * Book, Movie, Game
 */
public class Article implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected long id;
    
    @Column(name="title", length=255)
    private String title;
    @OneToMany(targetEntity=Review.class, mappedBy="article")
    @JsonIgnore
    protected List<Review> reviews;
    
    @Column(name="publishDate") //date de sortie mondiale du film,jeu,livre -> article
    protected Date publishDate;
    @Column(name="creationArticleDate", nullable=true) //date de publication sur le site
    protected Date creationArticleDate;
    
    @Column(name="minAge")
    protected int minAge;
    
    @Column(name="valid")
    protected boolean valid;
    
    @Column(name="webContent")
    @Lob
    protected String webContent;
    
    //Constructors
    
    public String getWebContent() {
        return webContent;
    }

    public void setWebContent(String webContent) {
        this.webContent = webContent;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Article(long id, String title, List<Review> reviews, Date publishDate, Date creationArticleDate, int minAge, boolean valid, String webContent) {
        super();
        this.id = id;
        this.title = title;
        this.reviews = reviews;
        this.publishDate = publishDate;
        this.creationArticleDate = creationArticleDate;
        this.minAge = minAge;
        this.valid = valid;
        this.webContent = webContent;
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
