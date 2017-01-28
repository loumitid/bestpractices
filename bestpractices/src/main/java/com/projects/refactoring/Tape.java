package com.projects.refactoring;

public class Tape extends DomainObject {
	
	private Movie movie;
	private String serialNumber;
	
	public Tape(String serialNumber, Movie movie) {
		this.serialNumber = serialNumber;
		this.movie = movie;
	}
	
	public Movie getMovie() {
		return this.movie;
	}
}
