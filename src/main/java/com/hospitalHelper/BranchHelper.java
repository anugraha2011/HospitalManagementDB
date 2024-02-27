package com.hospitalHelper;

import java.util.Scanner;

import com.hospitalEntity.Address;
import com.hospitalEntity.Branch;

public class BranchHelper {
	static Scanner s = new Scanner(System.in);
	
	public static Branch readBranch(Branch b) {
		Branch branch=b;
		
		System.out.println("Enter the branch name: ");
		String branch_name=s.next();
		
		System.out.println("Enter the branch capacity: ");
		int branch_capacity=s.nextInt();
		
		System.out.println("Is the branch open/close: ");
		String isOpen=s.next();
		
		System.out.println("Enter the established year: ");
		int establishedYear=s.nextInt();
		
		Address address=AddressHelper.readAddress();
		
		branch.setBranch_name(branch_name);
		branch.setBranch_capacity(branch_capacity);
		branch.setIsOpen(isOpen);
		branch.setEstablishedYear(establishedYear);
		branch.setAddress(address);
	//	branch.setEncounters(encounters);
		
		return branch;
	}
	
	public static int getBranchId() {
		System.out.println("Enter the branch id: ");
		int id=s.nextInt();
		return id;
	}


}
