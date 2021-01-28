package fr.dawan.sitecritiqueprojet.beans;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 
@DiscriminatorValue("game")
public class Game extends Article {
	
	@Column(name="genre", length=255, nullable = false)
	private String genre;
	@Column(name="developer", length=255)
	private String developer;
	@Column(name="publisher", length=255)
	private String publisher;
	@Column(name="platform", length=255)
	private String platform;
	@Column(name="resume", length=255, columnDefinition = "TEXT")
	private String resume;
	
	public Game() {
		super();
	}

	public Game(String genre, String developer, String publisher, String platform,
			String resume) {
		super();
		this.genre = genre;
		this.developer = developer;
		this.publisher = publisher;
		this.platform = platform;
		this.resume = resume;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	
	
}
