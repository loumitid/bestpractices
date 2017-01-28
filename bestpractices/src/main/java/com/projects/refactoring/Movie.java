package com.projects.refactoring;

import java.util.HashMap;
import java.util.Map;

public class Movie extends DomainObject {
	private static final int CHILDRENS = 2;
	private static final int REGULAR = 0;
	private static final int NEW_RELEASE = 1;

	public static Map<String, Object> registrar = new HashMap<String, Object>();

	private int priceCode;

	public Movie(String name, int priceCode) {
		this.name = name;
		this.priceCode = priceCode;
	}
	
	public static Movie newNewRelease(String name) {
		return new Movie(name, NEW_RELEASE);
	}
	
	public static Movie newRegular(String name) {
		return new Movie(name, REGULAR);
	}

	public static Movie newChildrens(String name) {
		return new Movie(name, CHILDRENS);
	}
	
	public void beRegular() {
        this.priceCode = REGULAR;
    }
    
    public void beNewRelease() {
        this.priceCode = NEW_RELEASE;
    }
    
    public void beChildrens() {
        this.priceCode = CHILDRENS;
    }
    
	public int getPriceCode() {
		return this.priceCode;
	}

	public void persist() {
		registrar.put("Movies", this);
	}

	public static Movie get(String name) {
		return (Movie) registrar.get("Movies");
	}

	double charge(int daysRented) {
		double result = 0;
		switch (getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (daysRented > 2) {
				result += (daysRented - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (daysRented > 3) {
				result += (daysRented - 3) * 1.5;
			}
			break;
		}

		return result;
	}
	
	int frequentRenterPoint(int daysRented) {
		if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
			return 2;
		}
		return 1;
	}
}
