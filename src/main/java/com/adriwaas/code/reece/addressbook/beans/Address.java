package com.adriwaas.code.reece.addressbook.beans;

import java.io.Serializable;

/**
 * @author Himadri Pant
 * 
 * Java bean to represent the address or contact.
 */
@SuppressWarnings("serial")
public class Address implements Serializable {
		
	public Address() {
		
	}	
	
	public Address(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	// Name of the Addresse
	private String name;
	
	// Phone number of the Addresse
	private String phoneNumber;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Address [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
}
