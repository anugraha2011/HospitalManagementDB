package com.hospitalHelper;

import java.util.Scanner;

import com.hospitalEntity.Hospital;

public class HospitalHelper {
static Scanner s=new Scanner(System.in);
	
	public static Hospital readHospital(Hospital h) {
		Hospital hospital=h;
		
		System.out.println("Enter the hospital name: ");
		String hospital_name=s.next();
			
		System.out.println("Enter the founded year of hospital: ");
		int foundedYear=s.nextInt();
	
		hospital.setHospital_name(hospital_name);
		hospital.setFoundedYear(foundedYear);
		
		return hospital;
	}
	
	public static int getHospitalId() {
		System.out.println("Enter the hospital id: ");
		int id=s.nextInt();
		return id;
	}

}
