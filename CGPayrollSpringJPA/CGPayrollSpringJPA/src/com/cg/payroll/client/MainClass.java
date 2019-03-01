package com.cg.payroll.client;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class MainClass {
	public static void main(String[] args) throws AssociateDetailsNotFoundException {
		ApplicationContext context=new ClassPathXmlApplicationContext("payrollBeans.xml");
		PayrollServices services=(PayrollServices) context.getBean("payrollServices");
		
		int associateId=services.acceptAssociateDetails("Vrinda","Munjal","Analyst","Staff","ABT21JJ7", "vmunjal1@gmail.com", 150000, 125468965,"Hdfc","fttg",50000,2000,5000);
		System.out.println("Associate Id: "+associateId);
		int associateId1=services.acceptAssociateDetails("Ram","Ahuja","Analyst","Staff","HGF12GH3","ram@gmail.com",160000, 245146655,"Hdfc","fttg",40000,2000,4000);
		System.out.println("Associate Id: "+associateId1);
		
		try {
			System.out.println(services.getAssociateDetails(101));
		} catch (AssociateDetailsNotFoundException ae) {
			System.out.println(ae.getMessage());
		}	
	}
}