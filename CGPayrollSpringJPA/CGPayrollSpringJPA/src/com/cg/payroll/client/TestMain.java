package com.cg.payroll.client;
import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class TestMain {
	public static void main(String args[]){
		PayrollServices services=new PayrollServicesImpl();
		int associateId1=services.acceptAssociateDetails("Vrinda","Munjal","Analyst","Staff","ABT21JJ7", "vmunjal1@gmail.com", 150000, 125468965,"Hdfc","fttg",50000,2000,5000);
		int associateId2=services.acceptAssociateDetails("Ram","Ahuja","Analyst","Staff","HGF12GH3","ram@gmail.com",160000, 245146655,"Hdfc","fttg",40000,2000,4000);
		System.out.println(services.getAllAssociateDetails());
	
		try {
			System.out.println(services.getAssociateDetails(associateId1));
			System.out.println(services.getAssociateDetails(associateId2));
		} catch (AssociateDetailsNotFoundException e) {
			e.printStackTrace();
		}
	}
}