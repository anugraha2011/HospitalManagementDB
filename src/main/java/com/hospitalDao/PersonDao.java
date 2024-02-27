package com.hospitalDao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hospitalEntity.Person;
import com.hospitalHelper.PersonHelper;

public class PersonDao {
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager manager = factory.createEntityManager();
	static EntityTransaction transaction = manager.getTransaction();
	static Scanner s = new Scanner(System.in);

	public static Person savePerson(Person person) {
		person = PersonHelper.readPerson();
		return person;
	}

	public static void removePerson(int id) {
		Person person = manager.find(Person.class, id);

		if (person != null) {
			transaction.begin();
			manager.remove(person);
			transaction.commit();
			System.out.println("Person removed");
		} else {
			System.out.println("Person id not found");
		}
	}

	public static Person findPersonById(int id) {
		Person person = manager.find(Person.class, id);

		if (person != null) {
			System.out.println("Person Id: " + person.getPerson_id());
			System.out.println("Firstname: " + person.getFirst_name());
			System.out.println("Lastname: " + person.getLast_name());
			System.out.println("Date of Birth: " + person.getDateOfBirth());
			System.out.println("Gender: " + person.getGender());
			return person;
		} else {
			System.out.println("Person id not found");
			return null;
		}
	}

	public static void updatePerson(Person person) {
		boolean flag = true;

		while (flag) {

			System.out.println("1. Update firstname\n2. Update lastname\n3. Update date of birth\n4. Exit");
			System.out.println("Enter your choice: ");
			int choice = s.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Enter the updated firstname: ");
				String name = s.next();

				person.setFirst_name(name);
				System.out.println("Firstname updated");
			}
				break;
			case 2: {
				System.out.println("Enter the updated lastname: ");
				String name = s.next();

				person.setLast_name(name);
				System.out.println("Lastname updated");
			}
				break;
			case 3: {
				System.out.println("Enter the updated date of birth: ");
				String date = s.next();

				person.setDateOfBirth(date);
				System.out.println("Date of birth updated");
			}
				break;
			case 4:
				flag = false;
				break;
			}
		}
	}

}
