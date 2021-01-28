package fr.dawan.sitecritiqueprojet.beans;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 
@DiscriminatorValue("2")
public class Games extends Article {
	
	@Column(name="genreGames", length=255)
	private String genreGames;
	@Column(name="developerGames", length=255)
	private String developerGames;
	@Column(name="publisherGames", length=255)
	private String publisherGames;
	@Column(name="platformGames", length=255)
	private String platformGames;
	@Column(name="resumeGames", length=255, columnDefinition = "TEXT")
	private String resumeGames;
	
	public Games() {
		super();
	}

	public Games(String genreGames, String developerGames, String publisherGames, String platformGames,
			String resumeGames) {
		super();
		this.genreGames = genreGames;
		this.developerGames = developerGames;
		this.publisherGames = publisherGames;
		this.platformGames = platformGames;
		this.resumeGames = resumeGames;
	}

	public String getGenreGames() {
		return genreGames;
	}

	public void setGenreGames(String genreGames) {
		this.genreGames = genreGames;
	}

	public String getDeveloperGames() {
		return developerGames;
	}

	public void setDeveloperGames(String developerGames) {
		this.developerGames = developerGames;
	}

	public String getPublisherGames() {
		return publisherGames;
	}

	public void setPublisherGames(String publisherGames) {
		this.publisherGames = publisherGames;
	}

	public String getPlatformGames() {
		return platformGames;
	}

	public void setPlatformGames(String platformGames) {
		this.platformGames = platformGames;
	}

	public String getResumeGames() {
		return resumeGames;
	}

	public void setResumeGames(String resumeGames) {
		this.resumeGames = resumeGames;
	}
	
	
}
