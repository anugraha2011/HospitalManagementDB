package com.hospitalDao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hospitalEntity.Address;

public class AddressDao {
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager manager = factory.createEntityManager();
	static EntityTransaction transaction = manager.getTransaction();
	static Scanner s = new Scanner(System.in);

	public static void updateAddress(Address address) {
		boolean flag = true;

		while (flag) {

			System.out.println("1. Update street\n2. Update city\n3. Update state\n4. Update zipcode\n5. Exit");
			System.out.println("Enter your choice: ");
			int choice = s.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Enter updated street: ");
				String street = s.next();

				address.setStreet(street);
				System.out.println("Street updated successfully");
			}
				break;
			case 2: {
				System.out.println("Enter updated city: ");
				String city = s.next();

				address.setCity(city);
				System.out.println("City updated successfully");
			}
				break;
			case 3: {
				System.out.println("Enter updated state: ");
				String state = s.next();

				address.setState(state);
				System.out.println("State updated successfully");
			}
				break;
			case 4: {
				System.out.println("Enter updated zipcode: ");
				int zipcode = s.nextInt();

				address.setZipCode(zipcode);
				System.out.println("Zipcode updated successfully");
			}
				break;
			case 5: {
				flag = false;
			}
			}
		}

	}

}
