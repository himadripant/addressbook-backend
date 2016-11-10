package com.adriwaas.code.reece.addressbook.dao;

import java.util.List;

import com.adriwaas.code.reece.addressbook.beans.Address;

/** 
 * @author Himadri Pant
 * 
 * Data Access Object interface 
 */
public interface AddressOperations {

	List<Address> getAddressBook();
	
	void addNewAddress(Address address);
	
	void removeAddress(Address address);
	
}
