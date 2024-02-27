package com.hospitalController;

import java.util.Scanner;

import com.hospitalDao.BranchDao;
import com.hospitalDao.EncounterDao;
import com.hospitalDao.HospitalDao;
import com.hospitalDao.ItemDao;
import com.hospitalDao.MedOrderDao;
import com.hospitalDao.PersonDao;
import com.hospitalEntity.Branch;
import com.hospitalEntity.Encounter;
import com.hospitalEntity.Hospital;
import com.hospitalEntity.MedOrders;
import com.hospitalHelper.BranchHelper;
import com.hospitalHelper.EncounterHelper;
import com.hospitalHelper.HospitalHelper;
import com.hospitalHelper.ItemHelper;
import com.hospitalHelper.MedOrdersHelper;
import com.hospitalHelper.PersonHelper;

public class HospitalController {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean flag = true;

		System.out.println("WELCOME TO HOSPITAL MANAGEMENT\n");
		while (flag) {
			System.out.println("1. Hospital Operations\n2. Branch Operations\n3. Encounter Operations");
			System.out.println("4. MedOrder Operations\n5. Item Operations\n6. Person Operations\n7. Exit\n");

			System.out.println("Enter your choice: ");
			int choice = s.nextInt();

			switch (choice) {
			case 1: {
				System.out.println(
						"1. Save hospital\n2. Find hospital by ID\n3. Update hospital details\n4. Remove hospital\n");
				System.out.println("Choose the operation to be performed: ");
				int ch = s.nextInt();

				switch (ch) {
				case 1: {
					HospitalDao.saveHospital(new Hospital());
				}
					break;
				case 2: {
					HospitalDao.findHospitalById(HospitalHelper.getHospitalId());
				}
					break;
				case 3: {
					HospitalDao.updateHospital(HospitalHelper.getHospitalId());
				}
					break;
				case 4: {
					HospitalDao.removeHospital(HospitalHelper.getHospitalId());
				}
					break;
				}
			}
				break;
			case 2: {
				System.out
						.println("1. Save branch\n2. Find branch by ID\n3. Update branch details\n4. Remove branch\n");
				System.out.println("Choose the operation to be performed: ");
				int ch = s.nextInt();

				switch (ch) {
				case 1: {
					BranchDao.saveBranch(new Branch());
				}
					break;
				case 2: {
					BranchDao.findBranchById(BranchHelper.getBranchId());
				}
					break;
				case 3: {
					BranchDao.updateBranch(BranchHelper.getBranchId());
				}
					break;
				case 4: {
					BranchDao.removeBranch(BranchHelper.getBranchId());
				}
					break;
				}
			}
				break;
			case 3: {
				System.out.println(
						"1. Save encounter\n2. Find encounter by ID\n3. Update encounter details\n4. Remove encounter\n");
				System.out.println("Choose the operation to be performed: ");
				int ch = s.nextInt();

				switch (ch) {
				case 1: {
					EncounterDao.saveEncounter(new Encounter());
				}
					break;
				case 2: {
					EncounterDao.findEncounterById(EncounterHelper.getEncounterId());
				}
					break;
				case 3: {
					EncounterDao.updateEncounter(EncounterHelper.getEncounterId());
				}
					break;
				case 4: {
					EncounterDao.removeEncounterById(EncounterHelper.getEncounterId());
				}
					break;
				}
			}
				break;
			case 4: {
				System.out.println(
						"1. Save medOrder\n2. Find medOrder by ID\n3. Update medOrder details\n4. Remove medOrder\n");
				System.out.println("Choose the operation to be performed: ");
				int ch = s.nextInt();

				switch (ch) {
				case 1: {
					MedOrderDao.saveMedOrders(new MedOrders());
				}
					break;
				case 2: {
					MedOrderDao.findMedOrderById(MedOrdersHelper.getMedOrderId());
				}
					break;
				case 3: {
					MedOrderDao.updateMedOrder(MedOrdersHelper.getMedOrderId());
				}
					break;
				case 4: {
					MedOrderDao.removeMedOrder(MedOrdersHelper.getMedOrderId());
				}
					break;
				}
			}
				break;
			case 5: {
				System.out.println("1. Find item by ID\n2. Remove item\n");
				System.out.println("Choose the operation to be performed: ");
				int ch = s.nextInt();

				switch (ch) {
				case 1: {
					ItemDao.findItemById(ItemHelper.getItemId());
				}
					break;
				case 2: {
					ItemDao.removeItem(ItemHelper.getItemId());
				}
					break;
				}
			}
				break;
			case 6: {
				System.out.println("1. Find person by ID\n2. Remove person\n");
				System.out.println("Choose the operation to be performed: ");
				int ch = s.nextInt();

				switch (ch) {
				case 1: {
					PersonDao.findPersonById(PersonHelper.getPersonId());
				}
					break;
				case 2: {
					PersonDao.removePerson(PersonHelper.getPersonId());
				}
					break;
				} 
			}
				break;
			case 7: {
				System.out.println("THANK YOU.........!!!!!");
				flag = false;
			}
				break;
			default:
				System.out.println("Invalid choice");
			}
		} 
	}

}
