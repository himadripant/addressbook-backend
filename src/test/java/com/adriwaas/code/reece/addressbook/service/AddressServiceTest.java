package com.adriwaas.code.reece.addressbook.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.adriwaas.code.reece.addressbook.beans.Address;
import com.adriwaas.code.reece.addressbook.dao.AddressOperationsImpl;

/** 
 * @author Himadri Pant
 * 
 * Tests for Service interface implementation class
 */
public class AddressServiceTest {

	private AddressService mService = new AddressServiceImpl(new AddressOperationsImpl());
	
	@Test
	public void that_records_areReturnedAsExpected() {
		Assert.assertNotNull(mService.getAddressBook());
	}
	
	@Test
	public void that_givenAddress_isAddedAsExpected() {
		List<Address> addresses = mService.getAddressBook();
		addresses.clear();
		Address address = new Address("Himadri", "0123");
		mService.addAddress(address);
		Assert.assertEquals("Address not added successfully", addresses.get(0).getName(), "Himadri");
	}
	
	@Test
	public void that_givenAddress_isRemovedAsExpected() {
		List<Address> addresses = mService.getAddressBook();
		addresses.clear();
		Address address = new Address("Himadri", "0123");
		mService.addAddress(address);
		mService.removeAddress(address);
		Assert.assertTrue("Address not removed successfully", addresses.size() == 0);
	}
	
	@Test
	public void that_sortingIsDoneAsExpected() {
		List<Address> addresses = mService.getAddressBook();
		addresses.clear();
		Address a = new Address("a", "000");
		Address b = new Address("b", "111");
		Address c = new Address("c", "222");
		Address d = new Address("d", "333");
		Address e = new Address("e", "444");
		Address f = new Address("f", "555");
		mService.addAddress(c);
		mService.addAddress(a);
		mService.addAddress(f);
		mService.addAddress(e);
		mService.addAddress(b);
		mService.addAddress(d);
		mService.sortAddressBookByName();
		Assert.assertEquals("Address not sorted successfully", addresses.get(0).getName(), "a");
		Assert.assertEquals("Address not sorted successfully", addresses.get(1).getName(), "b");
		Assert.assertEquals("Address not sorted successfully", addresses.get(2).getName(), "c");		
	}
	
	@Test
	public void that_uniqueAddressesFoundAsExpected() {
		List<Address> addressesFirst = mService.getAddressBook();
		addressesFirst.clear();
		Address a = new Address("a", "000");
		Address b = new Address("b", "111");
		Address d = new Address("d", "333");
		mService.addAddress(a);
		mService.addAddress(b);
		mService.sortAddressBookByName();
		List<Address> addressesSecond = new ArrayList<Address>();
		addressesSecond.add(a);
		addressesSecond.add(d);
		List<Address> addressesUnique = mService.printUniqueAddresses(addressesSecond);
		Assert.assertTrue("Unique address not found successfully", addressesUnique.contains(a));	
		Assert.assertTrue("Unique address not found successfully", addressesUnique.size() == 3);	
	}
	
}
