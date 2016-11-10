package com.adriwaas.code.reece.addressbook.service;

import java.util.List;

import com.adriwaas.code.reece.addressbook.beans.Address;

/** 
 * @author Himadri Pant
 * 
 * Service interface for behaviour
 */
public interface AddressService {

	void addAddress(Address address);
	
	List<Address> getAddressBook();
	
	void removeAddress(Address address);
	
	void sortAddressBookByName();
	
	List<Address> printUniqueAddresses(List<Address> addresses);
	
}
