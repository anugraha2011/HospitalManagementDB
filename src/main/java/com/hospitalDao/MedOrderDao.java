package com.hospitalDao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hospitalEntity.Encounter;
import com.hospitalEntity.Item;
import com.hospitalEntity.MedOrders;
import com.hospitalHelper.MedOrdersHelper;

public class MedOrderDao {
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager manager = factory.createEntityManager();
	static EntityTransaction transaction = manager.getTransaction();
	static Scanner s = new Scanner(System.in);

	public static void saveMedOrders(MedOrders medOrders) {

		System.out.println("Enter encounter id: ");
		int encounter_id = s.nextInt();

		Encounter encounter = manager.find(Encounter.class, encounter_id);

		if (encounter != null) {
			medOrders = MedOrdersHelper.readMedOrders(medOrders);
			List<MedOrders> medOrderList = encounter.getMedOrders();
			medOrderList.add(medOrders);
			encounter.setMedOrders(medOrderList);
			medOrders.setEncounters(encounter);
			

			transaction.begin();
			manager.persist(medOrders);
			transaction.commit();
			System.out.println("MedOrder saved");

		} else {
			System.out.println("Encounter id not found");
		}
	}

	public static void removeMedOrder(int id) {
		MedOrders medOrders = manager.find(MedOrders.class, id);

		if (medOrders != null) {

			transaction.begin();
			List<Item> items = medOrders.getItems();
			for (Item item : items) {
				manager.remove(item);
			}
			manager.remove(medOrders);
			transaction.commit();
		}
	}

	public static void updateMedOrder(int id) {
		MedOrders medOrders = manager.find(MedOrders.class, id);
		boolean flag = true;

		if (medOrders != null) {
			while (flag) {

				System.out.println(
						"1. Update order date\n2. Update payment mode\n3. Update frequency\n4. Update order cost\n5. Update item details\n6. Exit");

				System.out.println("Enter your choice: ");
				int choice = s.nextInt();

				switch (choice) {
				case 1: {
					System.out.println("Enter the updated order date: ");
					String date = s.next();

					medOrders.setOrderDate(date);
					System.out.println("Order date updated");
				}
					break;
				case 2: {
					System.out.println("Enter the updated payment mode: ");
					String mode = s.next();

					medOrders.setPaymentMode(mode);
					System.out.println("Payment mode updated");
				}
					break;
				case 3: {
					System.out.println("Enter the updated frequency: ");
					int freq = s.nextInt();

					medOrders.setFrequency(freq);
					System.out.println("Frequency updated");
				}
					break;
				case 4: {
					System.out.println("Enter updated order cost: ");
					double cost = s.nextDouble();

					medOrders.setOrderCost(cost);
					System.out.println("Order cost updated");
				}
					break;
				case 5: {
					medOrders.setItems(ItemDao.updateItem(medOrders.getItems()));
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
			manager.merge(medOrders);
			transaction.commit();
		} else {
			System.out.println("MedOrder id not found");

		}
	}

	public static MedOrders findMedOrderById(int id) {
		MedOrders medOrders = manager.find(MedOrders.class, id);

		if (medOrders != null) {
			System.out.println("Order id: " + medOrders.getOrder_id());
			System.out.println("Order date: " + medOrders.getOrderDate());
			System.out.println("Payment mode: " + medOrders.getPaymentMode());
			System.out.println("Frequncy: " + medOrders.getFrequency());
			System.out.println("Order cost: " + medOrders.getOrderCost());
			for(Item item:medOrders.getItems()) {
				System.out.println("Item id: "+item.getItem_id());
				System.out.println("Item name: "+item.getItem_name());
			}

			return medOrders;
		} else {
			System.out.println("Order id not found");
			return null;
		}

	}

}
