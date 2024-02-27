package com.hospitalDao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hospitalEntity.Item;
import com.hospitalHelper.ItemHelper;

public class ItemDao {
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager manager = factory.createEntityManager();
	static EntityTransaction transaction = manager.getTransaction();
	static Scanner s = new Scanner(System.in);

	public static Item saveItem(Item item) {
		transaction.begin();
		manager.persist(item);
		transaction.commit();
		System.out.println("Item saved");
		return item;
	}

	public static List<Item> updateItem(List<Item> item) {

		int id = ItemHelper.getItemId();
		Item items = manager.find(Item.class, id);
		boolean flag = true;

		while (flag) {

			System.out.println("1. Update item name\n2. Update unit price\n3. Update quantity\n4. Exit");
			System.out.println("Enter your choice: ");
			int choice = s.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Enter the updated item name: ");
				String name = s.next();

				items.setItem_name(name);
				System.out.println("Item name updated");
			}
				break;
			case 2: {
				System.out.println("Enter the updated unit price: ");
				double price = s.nextDouble();

				items.setUnitPrice(price);
				System.out.println("Item unit price updated");
			}
				break;
			case 3: {
				System.out.println("Enter the updated quantity");
				int qty = s.nextInt();

				items.setQuantity(qty);
				System.out.println("Item quantity updated");
			}
				break;
			case 4:
				flag = false;
				break;
			default:
				System.out.println("Invalid choice");
			}

			item.add(items);

			transaction.begin();
			manager.merge(items);
			transaction.commit();
		}
		return item;
	}

	public static Item findItemById(int id) {
		Item item = manager.find(Item.class, id);

		if (item != null) {
			System.out.println("Item id: " + item.getItem_id());
			System.out.println("Item name: " + item.getItem_name());
			System.out.println("Unit price: " + item.getUnitPrice());
			System.out.println("Quantity: " + item.getQuantity());
			return item;
		} else {
			System.out.println("Item id not found");
			return null;
		}
	}
	
	public static void removeItem(int id)
	{
		
		Item item = manager.find(Item.class, id);
		if(item != null)
		{
		transaction.begin();
		manager.remove(item);
		transaction.commit();
		}
		
		else
		{
			System.out.println("Item not found h");
		}
		
	}
	

}
