package com.hospitalHelper;

import java.util.Scanner;

import com.hospitalEntity.Address;

public class AddressHelper {
	static Scanner s=new Scanner(System.in);
	
	public static Address readAddress() {
		
		Address address=new Address();

		System.out.println("Enter the street: ");
		String street=s.next();
		
		System.out.println("Enter the city: ");
		String city=s.next();
		
		System.out.println("Enter the state: ");
		String state=s.next();
		
		System.out.println("Enter the zipcode: ");
		int zipCode=s.nextInt();
	
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZipCode(zipCode);
		
		return address;
	}
	
	public static int getAddressId() {
		System.out.println("Enter the address id: ");
		int id=s.nextInt();
		return id;
	}

}
