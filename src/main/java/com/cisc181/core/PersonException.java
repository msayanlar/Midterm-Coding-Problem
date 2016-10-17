package com.cisc181.core;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonException extends Exception {

	private Person person;
	private Date DOB;
	private String Number;

	public PersonException(Person person) {
		this.person = person;
	}

	public PersonException(PersonException personException) {

	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) throws PersonException {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 100);
		if (calendar.getTime().before(dOB)) {
			throw new PersonException(this);
		}

		this.DOB = dOB;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) throws PersonException {

		Pattern pattern = Pattern.compile("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$");
		if (!pattern.matcher(number).matches()) {
			throw new PersonException(this);
		}

		Number = number;

	}

	public Person getPerson() {
		return person;
	}

}
