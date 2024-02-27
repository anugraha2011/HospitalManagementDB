package com.hospitalDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hospitalEntity.Branch;
import com.hospitalEntity.Hospital;
import com.hospitalHelper.BranchHelper;

public class BranchDao {
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager manager = factory.createEntityManager();
	static EntityTransaction transaction = manager.getTransaction();
	static Scanner s = new Scanner(System.in);

	public static Branch saveBranch(Branch branch) {

		System.out.println("Enter the hospital id: ");
		int id = s.nextInt();

		Hospital hospital = manager.find(Hospital.class, id);
		List<Branch> branches = new ArrayList<Branch>();
		branch = BranchHelper.readBranch(branch);

		if (hospital != null) {
			branch.setHospital(hospital);
			branches.add(branch);
			hospital.setBranches(branches);
			transaction.begin();
			manager.persist(branch);
			transaction.commit();

			transaction.begin();
			manager.merge(hospital);
			transaction.commit();
			return branch;
		} else {
			System.out.println("Hospital id not found");
			return null;
		}
	}

	public static void removeBranch(int id) {
		Branch branch = manager.find(Branch.class, id);

		if (branch != null) {
			transaction.begin();
			manager.remove(branch);
			transaction.commit();
			System.out.println("Branch removed");
		} else {
			System.out.println("Branch id not found");
		}
	}

	public static Branch findBranchById(int id) {
		Branch branch = manager.find(Branch.class, id);

		if (branch != null) {
			System.out.println("Branch Id: " + branch.getBranch_id());
			System.out.println("Branch Name: " + branch.getBranch_name());
			System.out.println("Branch Capacity: " + branch.getBranch_capacity());
			System.out.println("Branch Open/Close: " + branch.getIsOpen());
			System.out.println("Established Year: " + branch.getEstablishedYear());
			System.out.println();
			System.out.println("Address id: " + branch.getAddress().getAddress_id());
			System.out.println("Address street: " + branch.getAddress().getStreet());
			System.out.println("Address city: " + branch.getAddress().getCity());
			System.out.println("Address state: " + branch.getAddress().getState());
			System.out.println("Address zipcode: " + branch.getAddress().getZipCode());
			System.out.println();
			System.out.println("Hospital id: " + branch.getHospital().getHospital_id());
			System.out.println();
			return branch;
		} else {
			System.out.println("Branch id not found");
			return null;
		}
	}

	public static void updateBranch(int id) {
		Branch branch = manager.find(Branch.class, id);
		boolean flag = true;

		if (branch != null) {
			while (flag) {
				System.out.println(
						"1. Update branch name\n2. Update branch capacity\n3. Update branch availabilty\n4. Update established year\n5. Update address\n6. Exit");

				System.out.println("Enter your choice: ");
				int choice = s.nextInt();
				switch (choice) {
				case 1: {
					System.out.println("Enter new branch name: ");
					String name = s.next();

					branch.setBranch_name(name);
					System.out.println("Branch name updated successfully");
				}
					break;
				case 2: {
					System.out.println("Enter updated branch capacity: ");
					int capacity = s.nextInt();

					branch.setBranch_capacity(capacity);
					System.out.println("Capacity updated successfully");
				}
					break;
				case 3: {
					System.out.println("Is the branch Open/Close");
					String isOpen = s.next();

					branch.setIsOpen(isOpen);
					System.out.println("Availability updated");
				}
					break;
				case 4: {
					System.out.println("Enter the updated established year: ");
					int year = s.nextInt();

					branch.setEstablishedYear(year);
					System.out.println("Established year updated successfully");
				}
					break;
				case 5: {
					AddressDao.updateAddress(branch.getAddress());
				}
					break;
				case 6:
					flag = false;
					break;
				default:
					System.out.println("Invalid choice");
				}
			}
			transaction.begin();
			manager.merge(branch);
			transaction.commit();
		} else {
			System.out.println("Branch id not found");
		}
	}

}
