package com.devTest.Movies.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table (name = "movies")
public class Movies {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //PRIMARY KEY
	private long movieId;
	
	@NotNull // NÃO PODERÁ FICAR VAZIO
	private String title;
	
	@NotNull
	private String genres;

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}
	
}
