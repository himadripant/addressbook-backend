package com.adriwaas.code.reece.addressbook.dao;

import org.junit.Test;
import org.junit.Assert;

import java.util.List;

import com.adriwaas.code.reece.addressbook.beans.Address;
import com.adriwaas.code.reece.addressbook.dao.AddressOperations;
import com.adriwaas.code.reece.addressbook.dao.AddressOperationsImpl;

/** 
 * @author Himadri Pant
 * 
 * Tests for Service interface implementation for behaviour
 */
public class AddressOperationsTest {

	private AddressOperations mOperations = new AddressOperationsImpl();
	
	/**
	 *  Unit test to check com.adriwaas.code.reece.addressbook.dao.AddressOperationsImpl.getAddressBook()
	 */
	@Test
	public void that_records_areReturnedAsExpected() {
		Assert.assertNotNull(mOperations.getAddressBook());
	}
	
	/**
	 *  Unit test to check com.adriwaas.code.reece.addressbook.dao.AddressOperationsImpl.addNewAddress(Address)
	 */
	@Test
	public void that_givenAddress_isAddedAsExpected() {
		List<Address> addresses = mOperations.getAddressBook();
		addresses.clear();
		Address address = new Address("Himadri", "0123");
		mOperations.addNewAddress(address);
		Assert.assertEquals("Address not added successfully", addresses.get(0).getName(), "Himadri");
	}
	
	/**
	 *  Unit test to check com.adriwaas.code.reece.addressbook.dao.AddressOperationsImpl.removeAddress(Address)
	 */
	@Test
	public void that_givenAddress_isRemovedAsExpected() {
		List<Address> addresses = mOperations.getAddressBook();
		addresses.clear();
		Address address = new Address("Himadri", "0123");
		mOperations.addNewAddress(address);
		mOperations.removeAddress(address);
		Assert.assertTrue("Address not removed successfully", addresses.size() == 0);
	}
	
}
