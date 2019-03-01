//package com.cg.payroll.test;
//import java.util.ArrayList;
//import org.junit.After;
//import org.junit.Test;
//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import com.cg.payroll.beans.Associate;
//import com.cg.payroll.beans.BankDetails;
//import com.cg.payroll.beans.Salary;
//import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
////import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
//import com.cg.payroll.services.PayrollServices;
//import com.cg.payroll.services.PayrollServicesImpl;
//public class PayrollServicesTest {
//	private static PayrollServices services;
	/*
	@BeforeClass
	public static void setUpTestEnv() {
		services=new PayrollServicesImpl();
	}
	@Before
	public void setUpTestData() {
		Associate associate1=new Associate(101,555,"Vrinda", "Munjal","IT","VVVV", "AWX123W", "vmunjal1@gmail.com", new Salary(10000, 134,544), new BankDetails(125, "ICICI","13556"));
		Associate associate2=new Associate(102,553,"Sukh", "singh","IT","WWWW", "ABT21JJ7", "SUKH2@gmail.com", new Salary(150000, 125,764), new BankDetails(1235, "HDFC","3452"));

		PayRollDBUtil.associates.put(associate1.getAssociatedId(),associate1);
		PayRollDBUtil.associates.put(associate2.getAssociatedId(),associate2);

		PayRollDBUtil.ASSOCIATE_ID_COUNTER=102;
	}
	@Test
	(expected=AssociateDetailsNotFoundException.class)
	public void testGetAssociateDetailsForInvalidAssociateId()throws AssociateDetailsNotFoundException{			
		services.getAssociateDetails(12343);
	}			
	@Test
	public void testGetAssociateDetailsForValidAssociateId() throws AssociateDetailsNotFoundException{
		Associate expectedAssociate=new Associate(102,553,"Sukh", "singh","IT","WWWW", "ABT21JJ7", "SUKH2@gmail.com", new Salary(150000, 125,764), new BankDetails(1235, "HDFC","3452"));
		Associate actualAssociate=services.getAssociateDetails(102);
		Assert.assertEquals(expectedAssociate, actualAssociate);
	}

	@Test
	public void testAcceptAssociateDetailsForValidData() {
		int expectedId=103;
		int actualId=services.acceptAssociateDetails("Ram", "Ahuja", "Analyst", "Staff", "HGF12GH3", "hgyujj1@gmail.com", 1600000, 24514689, "Hdfc", "fttg", 40000, 2000,4000);
		Assert.assertEquals(expectedId, actualId);
	}
	@Test
	(expected=AssociateDetailsNotFoundException.class)
	public void testCalculateNetSalaryForInvalidAssociateId()throws AssociateDetailsNotFoundException{			
		services.calculateNetSalary(143);
	}			
	@Test
	public void testCalculateNetSalaryForValidAssociateId()throws AssociateDetailsNotFoundException{
		int expectedNetSalary=3699779;
		int actualNetSalary=services.calculateNetSalary(102);
		Assert.assertEquals(expectedNetSalary, actualNetSalary);
	}
	@Test
	public void testGetAllAssociatesDetails() {
		Associate associate1=new Associate(101,555,"Vrinda", "Munjal","IT","VVVV", "AWX123W", "vmunjal1@gmail.com", new Salary(10000, 134,544), new BankDetails(125, "ICICI","13556"));
		Associate associate2=new Associate(102,553,"Sukh", "singh","IT","WWWW", "ABT21JJ7", "SUKH2@gmail.com", new Salary(150000, 125,764), new BankDetails(1235, "HDFC","3452"));

		ArrayList<Associate>expectedAssociateList=new ArrayList<>();
		expectedAssociateList.add(associate1);
		expectedAssociateList.add(associate2);

		ArrayList<Associate>actualAssociateList=(ArrayList<Associate>)services.getAllAssociateDetails();

		Assert.assertEquals(expectedAssociateList, actualAssociateList);
	}
	@After
	public void tearDownTestData() {
		PayRollDBUtil.associates.clear();
		PayRollDBUtil.ASSOCIATE_ID_COUNTER=100;
	}
	@AfterClass
	public static void tearDownTestEnv() {
		services=null;
		}*/
//}