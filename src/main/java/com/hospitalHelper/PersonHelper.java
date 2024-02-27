package com.hospitalHelper;

import java.util.Scanner;

import com.hospitalEntity.Person;

public class PersonHelper {
	static Scanner s=new Scanner(System.in);
	
	public static Person readPerson() {
		Person person=new Person();
		
		System.out.println("Enter the first name of patient: ");
		String first_name=s.next();
		
		System.out.println("Enter the last name of patient: ");
		String last_name=s.next();
		
		System.out.println("Enter the date of birth: ");
		String dateOfBirth=s.next();
		
		System.out.println("Enter the gender: ");
		String gender=s.next();
		
		person.setFirst_name(first_name);
		person.setLast_name(last_name);
		person.setDateOfBirth(dateOfBirth);
		person.setGender(gender);
		
		return person;
		
	}
	
	public static int getPersonId() {
		System.out.println("Enter the person id: ");
		int id=s.nextInt();
		return id;
	}

}
