package com.caresoft.clinicapp.models;

import java.util.ArrayList;
import java.util.Date;

import com.caresoft.clinicapp.interfaces.HIPAACompliantAdmin;
import com.caresoft.clinicapp.interfaces.HIPAACompliantUser;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
	private String role;
	private ArrayList<String> securityIncidents;
	
	public AdminUser(int id, String role) {
		super(id);
		this.setRole(role);
		
	}
	public boolean assignPin(int pin) {
		if(pin >= 6){
			return false;
		}else {
			setPin(pin);
			return true;
		}
	}
    public boolean accessAuthorized(Integer confirmedAuthId) {
    	if(confirmedAuthId != id) {
//    		reportSecurityIncidents();
//    		String report = String.format(
//    	            "Datetime Submitted: %s \n,  Reported By ID: %s\n", 
//    	            new Date(), this.id
//    	        );
//    		
////    		START HERE THIS IS NOT ADDING A REPORT CORRECTLY
//    		securityIncidents.add(report);
    		return false;
    	}else {
    		return true;
    	}
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
        System.out.println(securityIncidents);
	
    }
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		ArrayList<String> reports = new ArrayList<String>();
		System.out.println("You have lost the game.");
		System.out.println("securityIncidents " + securityIncidents);
//		reports.add(report);
		System.out.println(reports);
//		setSecurityIncidents();
//		System.out.println("reports: " + reports);
//		System.out.println("securityIncidents" + securityIncidents.add(role));
		return reports;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
}
