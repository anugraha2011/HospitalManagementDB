package com.hospitalHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hospitalEntity.Item;
import com.hospitalEntity.MedOrders;

public class MedOrdersHelper {
	static Scanner s = new Scanner(System.in);

	public static MedOrders readMedOrders(MedOrders mo) {
		MedOrders medOrders = mo;

		System.out.println("Enter the order date: ");
		String orderDate = s.next();

		System.out.println("Enter the payment mode: ");
		String paymentMode = s.next();

		System.out.println("Enter the frequency: ");
		int frequency = s.nextInt();

		System.out.println("Enter the cost: ");
		double orderCost = s.nextDouble();

		List<Item> items = new ArrayList<Item>();
		boolean flag = true;
		while (flag) {
			System.out.println("1. Add items\n2. Exit");
			int choice = s.nextInt();

			switch (choice) {
			case 1: {
				Item item = ItemHelper.readItem();
				items.add(item);
			}
				break;
			case 2: {
				flag = false;
			}
				break;
			}
		}

		medOrders.setOrderDate(orderDate);
		medOrders.setPaymentMode(paymentMode);
		medOrders.setFrequency(frequency);
		medOrders.setOrderCost(orderCost);
		medOrders.setItems(items);

		return medOrders;
	}
	
	public static int getMedOrderId() {
		System.out.println("Enter the medOrder id: ");
		int id=s.nextInt();
		return id;
	}

}
