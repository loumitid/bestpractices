package com.projects.refactoring;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Customer extends DomainObject {

	private List<Rental> rentals = new LinkedList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentals.add(arg);
	}

	public void persist() {
		Movie.registrar.put("Customers", this);
	}

	public static Customer get(String name) {
		return (Customer) Movie.registrar.get("Customers");
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		Iterator<Rental> it = rentals.iterator();
		while (it.hasNext()) {
			Rental each = it.next();

			// determine amounts for each line
			totalAmount += each.getTape().getMovie().charge(each.getDaysRented());

			frequentRenterPoints += each.frequentRenterPointOf();

			result += "\t" + each.getTape().getMovie().getName() + "\t"
					+ String.valueOf(each.getTape().getMovie().charge(each.getDaysRented())) + "\n";
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

}
