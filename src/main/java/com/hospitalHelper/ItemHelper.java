package com.hospitalHelper;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hospitalEntity.Item;

public class ItemHelper {
	static Scanner s=new Scanner(System.in);
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
	static EntityManager manager = factory.createEntityManager();
	static EntityTransaction transaction = manager.getTransaction();
	
	public static Item readItem(){
		Item item=new Item();
		
		System.out.println("Enter the item name: ");
		String item_name=s.next();
		
		System.out.println("Enter the unit price: ");
		double unitPrice=s.nextDouble();
		
		System.out.println("Enter the quantity: ");
		int quantity=s.nextInt();
		
		item.setItem_name(item_name);
		item.setUnitPrice(unitPrice);
		item.setQuantity(quantity);
		
		transaction.begin();
		manager.persist(item);
		transaction.commit();
		System.out.println("Item saved");
		
		return item;
	}
	
	public static int getItemId() {
		System.out.println("Enter the item id: ");
		int id=s.nextInt();
		return id;
	}

}
