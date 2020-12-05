package com.libapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "Genre.getByName", query = "from Genre where genreName=?")
@Table(name="GENRE")
public class Genre {

	
	private int genreId;
	private String genreName;
	
	
	@Id
	@Column(name="GenreId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_generator")
	@SequenceGenerator(name = "genre_generator", sequenceName = "GENRE_SEQUENCE",allocationSize = 1,initialValue = 1)
	public int getGenreId() {
		return genreId;
	}
	
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	
	@Column(name = "genreName")
	public String getGenreName() {
		return genreName;
	}
	
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	
	public Genre() {
		super();
	}


	public Genre(String genreName) {
		this.genreName = genreName;
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreName=" + genreName + "]";
	}
	
	
}