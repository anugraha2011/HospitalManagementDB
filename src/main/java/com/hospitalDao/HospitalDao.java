package com.hospitalDao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hospitalEntity.Hospital;
import com.hospitalHelper.HospitalHelper;

public class HospitalDao {

	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager manager = factory.createEntityManager();
	static EntityTransaction transaction = manager.getTransaction();
	static Scanner s = new Scanner(System.in);

	public static Hospital saveHospital(Hospital hospital) {
		hospital = HospitalHelper.readHospital(hospital);
		transaction.begin();
		manager.persist(hospital);
		transaction.commit();
		System.out.println("Hospital saved");

		return hospital;
	}

	public static void removeHospital(int id) {
		Hospital hospital = manager.find(Hospital.class, id);

		if (hospital != null) {
			transaction.begin();
			manager.remove(hospital);
			transaction.commit();
		} else {
			System.out.println("Hospital id not found");
		}
	}

	public static Hospital findHospitalById(int id) {
		Hospital hospital = manager.find(Hospital.class, id);

		if (hospital != null) {
			System.out.println("Hospital Id: " + hospital.getHospital_id());
			System.out.println("Hospital Name: " + hospital.getHospital_name());
			System.out.println("Founded Year: " + hospital.getFoundedYear());
			return hospital;
		} else {
			System.out.println("Hospital with given id does not exist");
			return null;
		}
	}

	public static void updateHospital(int id) {

		Hospital hospital = manager.find(Hospital.class, id);
		boolean flag = true;

		if (hospital != null) {
			while (flag) {
				System.out.println("1. Update hospital name\n2. Update founded year\n3. Exit");

				System.out.println("Enter your choice: ");
				int choice = s.nextInt();

				switch (choice) {
				case 1: {
					System.out.println("Enter new hospital name: ");
					String name = s.next();

					hospital.setHospital_name(name);
					System.out.println("Hospital name updated successfully");
				}
					break;
				case 2: {
					System.out.println("Enter updated founded year: ");
					int year = s.nextInt();

					hospital.setFoundedYear(year);
					System.out.println("Year updated successfully");
				}
					break;
				case 3:
					flag = false;
					break;
				}
			}
			transaction.begin();
			manager.merge(hospital);
			transaction.commit();
		} else {
			System.out.println("Hospital id not found");
		}

	}

}
