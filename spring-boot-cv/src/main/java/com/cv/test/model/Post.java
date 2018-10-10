package com.cv.test.model;

import javax.validation.constraints.Size;

public class Post {
	
	@Size(min=4, max=35)
	private String firstName;
	
	@Size(min=4, max=35)
	private String lastName;	


	private String country;
	
	private String datetimeField;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDatetimeField() {
		return datetimeField;
	}

	public void setDatetimeField(String datetimeField) {
		this.datetimeField = datetimeField;
	}

	
	
	
}
