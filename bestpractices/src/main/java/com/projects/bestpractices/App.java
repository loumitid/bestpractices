package com.projects.bestpractices;

import java.util.Date;
import java.util.List;

public class App {

	// PROBLEMS ?
	// name of method : transforming what ?
	// name of variables : what is d and dates ?
	// what is semantic of variables ?
	// OOM ?: a lot of string will be created (immuable)
	// a lot of 'if then else'
	public String transform(List<Date> dates) {
		String d = null;

		for (Date date : dates) {
			if (date.after(new Date())) {
				d += date.toString() + "\n";
			} else {
				d += "Delayed\n";
			}
		}
		return d;
	}

	// Correction ?
	// name of variables
	// variables's semantic
	// OOM : yes creating 2 string rather than 4
	// semantic of method's name
	// PROBLEMS ?
	// always problem of a lot of 'if then else' : what is we use ternary
	// condition ?
	public String getText(List<Date> arrivalDates) {
		StringBuilder textOfArrivalDates = new StringBuilder();

		for (Date arrivalDate : arrivalDates) {
			String msg = arrivalDate.after(new Date()) ? arrivalDate.toString() : "Delayed";
			textOfArrivalDates.append(msg);

			/* 'IF THEN ELSE' version */
			// if (arrivalDate.after(new Date())) {
			// textOfArrivalDates.append(arrivalDate);
			// } else {
			// textOfArrivalDates.append("Delayed");
			// }
		}
		return textOfArrivalDates.toString();
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
