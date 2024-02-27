package com.hospitalDao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hospitalEntity.Branch;
import com.hospitalEntity.Encounter;
import com.hospitalEntity.Person;
import com.hospitalHelper.EncounterHelper;

public class EncounterDao {
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager manager = factory.createEntityManager();
	static EntityTransaction transaction = manager.getTransaction();
	static Scanner s = new Scanner(System.in);

	public static void saveEncounter(Encounter encounter) {

		System.out.println("Enter the branch id: ");
		int id = s.nextInt();

		Branch branch = manager.find(Branch.class, id);

		if (branch != null) {
			System.out.println("Check whether the patient id exist\nEnter the patient id: ");
			int person_id = s.nextInt();
			Person person = manager.find(Person.class, person_id);

			if (person != null) {

				encounter = EncounterHelper.readEncounter(encounter);
				List<Encounter> encounters = branch.getEncounters();
				encounter.setBranches(branch);
				encounters.add(encounter);
				branch.setEncounters(encounters);
				encounter.setPerson(person);

				transaction.begin();
				manager.persist(encounter);
				transaction.commit();

				transaction.begin();
				manager.merge(branch);
				transaction.commit();

			} else {

				System.out.println("Person not found\nKindly add new person");
				Person personNew = PersonDao.savePerson(person);
				encounter.setBranches(branch);
				
				encounter = EncounterHelper.readEncounter(encounter);
				encounter.setPerson(personNew);
				List<Encounter> encounters = branch.getEncounters();
				encounters.add(encounter);
				branch.setEncounters(encounters);
			
				
				transaction.begin();
				manager.persist(encounter);
				transaction.commit();

				transaction.begin();
				manager.merge(branch);
				transaction.commit();
			}
		} else {
			System.out.println("Branch id not found");
		}

	}

	public static void removeEncounterById(int id) {
		Encounter encounter = manager.find(Encounter.class, id);

		if (encounter != null) {
			transaction.begin();
			manager.remove(encounter);
			transaction.commit();
			System.out.println("Encounter removed");
		} else {
			System.out.println("Encounter id not found");
		}
	}

	public static Encounter findEncounterById(int id) {
		Encounter encounter = manager.find(Encounter.class, id);

		if (encounter != null) {
			System.out.println("Encounter Id: " + encounter.getEncounter_id());
			System.out.println("Patient firstname: "+encounter.getPerson().getFirst_name());
			System.out.println("Patient lastname: "+encounter.getPerson().getLast_name());
			System.out.println("Patient gender: "+encounter.getPerson().getGender());
			System.out.println("Diagnosis: "+encounter.getDiagnosis());
			System.out.println("Patient Status: " + encounter.getPatientStatus());
			return encounter;
		} else {
			System.out.println("Encounter id not found");
			return null;
		}
	}

	public static void updateEncounter(int id) {
		Encounter encounter = manager.find(Encounter.class, id);
		boolean flag = true;

		if (encounter != null) {
			while (flag) {

				System.out.println(
						"1. Update admission date\n2. Update discharge date\n3. Update diagnosis\n4. Update patient status\n5. Update person details\n6. Exit");

				System.out.println("Enter your choice: ");
				int choice = s.nextInt();

				switch (choice) {
				case 1: {
					System.out.println("Enter the updated admission date: ");
					String date = s.next();

					encounter.setAdmissionDate(date);
					System.out.println("Admission date updated");
				}
					break;
				case 2: {
					System.out.println("Enter the updated discharge date: ");
					String date = s.next();

					encounter.setDischargeDate(date);
					System.out.println("Discharge date updated");
				}
					break;
				case 3: {
					System.out.println("Enter the updated diagnosis: ");
					String diagnosis = s.next();

					encounter.setDiagnosis(diagnosis);
					System.out.println("Diagnosis updated successfully");
				}
					break;
				case 4: {
					System.out.println("Enter updated patient status: ");
					String status = s.next();

					encounter.setPatientStatus(status);
					System.out.println("Patient status updated");
				}
					break;
				case 5: {
					PersonDao.updatePerson(encounter.getPerson());
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
			manager.merge(encounter);
			transaction.commit();
		} else {
			System.out.println("Encounter id not found");

		}
	}

}
