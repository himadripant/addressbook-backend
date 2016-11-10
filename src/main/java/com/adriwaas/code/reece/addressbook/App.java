package com.adriwaas.code.reece.addressbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.adriwaas.code.reece.addressbook.beans.Address;
import com.adriwaas.code.reece.addressbook.dao.AddressOperationsImpl;
import com.adriwaas.code.reece.addressbook.service.AddressService;
import com.adriwaas.code.reece.addressbook.service.AddressServiceImpl;

/**
 * @author Himadri Pant
 *
 * The application starts from here.
 */
public class App {
	
	final private AddressService mService = new AddressServiceImpl(new AddressOperationsImpl());

	public static void main(String[] args) {

		App app = new App();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println("Enter 1 to add new address : ");
				System.out.println("Enter 2 to remove an address : ");
				System.out.println("Enter 3 to sort address book : ");
				System.out.println("Enter 4 to print unique addresses : ");
				System.out.println("Enter !q to leave : ");
				String input = reader.readLine();
				System.out.println("input : " + input);
				switch (input) {
				case "!q":
					System.out.println("Exiting the application !!!");
					System.exit(0);
					break;

				case "1":
					app.addAddress(reader);
					break;

				case "2":
					app.removeAddress(reader);
					break;

				case "3":
					app.sortAddressBook(reader);
					break;

				case "4":
					app.findUniqueAddresses(reader);
					break;

				default:
					break;
				}
				System.out.println("-----------\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void addAddress(BufferedReader reader) throws IOException {
		System.out.println("Add addresse name : ");
		String input = reader.readLine();
		final Address address = new Address();
		address.setName(input);
		System.out.println("Add addresse phonenumber : ");
		input = reader.readLine();
		address.setPhoneNumber(input);
		mService.addAddress(address);
		System.out.println("Address book : " + mService.getAddressBook());
		System.out.println("-----------\n");
	}

	private void removeAddress(BufferedReader reader) throws IOException {
		System.out.println("Remove addresse name : ");
		String input = reader.readLine();
		final Address address = new Address();
		address.setName(input);
		System.out.println("Remove addresse phonenumber : ");
		input = reader.readLine();
		address.setPhoneNumber(input);
		mService.removeAddress(address);
		System.out.println("Address book : " + mService.getAddressBook());
		System.out.println("-----------\n");	
	}

	private void sortAddressBook(BufferedReader reader) throws IOException {
		mService.sortAddressBookByName();
		System.out.println("Sorted Address book : " + mService.getAddressBook());
	}

	private void findUniqueAddresses(BufferedReader reader) throws IOException {
		final List<Address> newAddresses = new ArrayList<Address>();
		while (true) {
			System.out.println("Add addresse name : ");
			String input = reader.readLine();
			final Address address = new Address();
			address.setName(input);
			System.out.println("Add addresse phonenumber : ");
			input = reader.readLine();
			address.setPhoneNumber(input);
			newAddresses.add(address);
			System.out.println("Enter y to see unique addresses or any other string to continue adding : ");
			input = reader.readLine();
			if (input.equalsIgnoreCase("y")) 
				break;
		}
		System.out.println("Unique addresses among both address books : " + 
				mService.printUniqueAddresses(newAddresses));
	}
}
