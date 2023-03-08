package it.uniroma3.siw.model;

import jakarta.persistence.*;


@Entity
public class Movie {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
    private String title;
    private Integer year;
    private String urlImage;
    
    public Movie() {
    	super();
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
    
    
    

}
