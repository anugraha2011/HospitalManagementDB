package com.hospitalHelper;

import java.util.Scanner;

import com.hospitalEntity.Encounter;

public class EncounterHelper {
	static Scanner s=new Scanner(System.in);
	
	public static Encounter readEncounter(Encounter e){
		Encounter encounter=e;
		
		System.out.println("Enter the admission date: ");
		String admissionDate=s.next();
		
		System.out.println("Enter the discharge date: ");
		String dischargeDate=s.next();
		
		System.out.println("Enter the diagnosis: ");
		String diagnosis=s.next();
		
		System.out.println("Enter the patient status: ");
		String patientStatus=s.next();
		
		encounter.setAdmissionDate(admissionDate);
		encounter.setDischargeDate(dischargeDate);
		encounter.setDiagnosis(diagnosis);
		encounter.setPatientStatus(patientStatus);
		
		return encounter;
	}
	
	public static int getEncounterId() {
		System.out.println("Enter the encounter id: ");
		int id=s.nextInt();
		return id;
	}

}
