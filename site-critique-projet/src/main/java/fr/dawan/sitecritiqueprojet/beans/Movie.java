package fr.dawan.sitecritiqueprojet.beans;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Movie extends Article{

    @Column(name="realisator", length=1000, nullable=true)
    private String realisator;
    
    @Column(name="genre", length=1000, nullable=true)
    private String genre;
    
    @Column(name="actors", length=1000, nullable=true)
    private String actors;
    
    @Column(name="duration", nullable=true)
    private int duration;
    
    @Column(name="nationality", length=50, nullable=true)
    private String nationality;
    
    @Column(name="synopsys", length=10000, nullable=true)
    private String synopsys;

    public String getRealisator() {
        return realisator;
    }

    public void setRealisator(String realisator) {
        this.realisator = realisator;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSynopsys() {
        return synopsys;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }
    
}
