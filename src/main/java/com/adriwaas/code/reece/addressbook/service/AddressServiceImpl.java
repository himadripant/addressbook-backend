package com.adriwaas.code.reece.addressbook.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adriwaas.code.reece.addressbook.beans.Address;
import com.adriwaas.code.reece.addressbook.dao.AddressOperations;

/** 
 * @author Himadri Pant
 * 
 * Service interface implementation for behaviour
 */
public class AddressServiceImpl implements AddressService {
	
	public AddressServiceImpl(AddressOperations operations) {
		mOperations = operations;
	}
	
	final private AddressOperations mOperations;

	/**
	 * @param Address new contact to be added in address book.
	 * @return void
	 */
	@Override
	public void addAddress(Address address) {
		mOperations.addNewAddress(address);
	}

	/**
	 * @return list of addresses from address book
	 */
	@Override
	public List<Address> getAddressBook() {
		return mOperations.getAddressBook();
	}

	/**
	 * @param Address object to be deleted from address list
	 * @return void
	 */
	@Override
	public void removeAddress(Address address) {
		mOperations.removeAddress(address);
	}

	/**
	 * Sorts the list
	 * @return void
	 */
	@Override
	public void sortAddressBookByName() {
		List<Address> addresses = getAddressBook();
		addresses.sort((addr1, addr2) ->  addr1.getName().compareTo(addr2.getName()));
	}

	/**
	 * calculates unique addresses in database matched against the passed addresses. 
	 * 
	 * @param List<Address> second address book
	 * @return list of unique address objects
	 */
	@Override
	public List<Address> printUniqueAddresses(List<Address> addresses) {
		Map<String, Address> addressesUnique = new HashMap<String, Address>();
		List<Address> addressesOriginal = getAddressBook();
		
		for (Address address : addressesOriginal) 
			addressesUnique.put(address.getName(), address);
		
		for (Address address : addresses) {
			addressesUnique.put(address.getName(), address);
		}
		
		return new ArrayList<Address>(addressesUnique.values());
	}

}
