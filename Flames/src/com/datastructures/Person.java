package com.datastructures;

import java.io.Serializable;

/**
 * 
 */

/**
 * @author Arockia
 *
 */
public class Person implements Serializable {

	private static final long serialVersionUID = 2754097042737306271L;

	private String firstName;

	private String lastName;

	private String middleName;

	public Person(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Override
	public String toString() {
		StringBuffer personBuffer = new StringBuffer();
		personBuffer.append(firstName).append(" ").append(middleName).append(" ").append(lastName).append(" ");
		return personBuffer.toString();
	}

}
