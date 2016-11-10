package com.adriwaas.code.reece.addressbook.dao;

import java.util.ArrayList;
import java.util.List;

import com.adriwaas.code.reece.addressbook.beans.Address;


/** 
 * @author Himadri Pant
 * 
 * Data Access Object interface implementation
 */
public class AddressOperationsImpl implements AddressOperations {
	
	final private List<Address> mAddresses;
	
	public AddressOperationsImpl() {
		mAddresses = new ArrayList<Address>();
	}

	/**
	 * @return list of addresses in the address book
	 */
	@Override
	public List<Address> getAddressBook() {
		return mAddresses;
	}

	/**
	 * @param Address new contact in the address book
	 * @return void
	 */
	@Override
	public void addNewAddress(Address address) {
		mAddresses.add(address);		
	}

	/**
	 * @param Address contact to be removed from address book
	 * @return void
	 */
	@Override
	public void removeAddress(Address address) {
		mAddresses.removeIf((addr) -> addr.getName().equals(address.getName()));
	}

}
