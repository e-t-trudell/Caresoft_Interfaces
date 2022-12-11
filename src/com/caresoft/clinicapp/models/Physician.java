package com.caresoft.clinicapp.models;


import java.util.ArrayList;
import java.util.Date;

import com.caresoft.clinicapp.interfaces.HIPAACompliantUser;

public class Physician extends User implements  HIPAACompliantUser {
	private ArrayList<String> patientNotes;
//	implement HIPAACompliantUser
	public boolean assignPin(int pin) {
		if(pin > 4){
			return false;
		}else {
			return true;
		}
	}
    public boolean accessAuthorized(Integer confirmedAuthId) {
    	if(confirmedAuthId != id) {
    		return false;
    	}else {
    		return true;
    	}
    }
	
	public Physician(int id) {
		super(id);
		System.out.println("Physician id: " + id);
	}

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
}
