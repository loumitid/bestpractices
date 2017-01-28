package com.projects.refactoring;

public class Rental extends DomainObject {

	private int daysRented;
	private Tape tape;

	public Rental(Tape tape, int daysRented) {
		this.tape = tape;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return this.daysRented;
	}

	public Tape getTape() {
		return this.tape;
	}

	int frequentRenterPointOf() {
		return getTape().getMovie().frequentRenterPoint(daysRented);
	}

	double charge() {
		return this.getTape().getMovie().charge(daysRented);
	}

}
