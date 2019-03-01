//package com.cg.payroll.test;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.easymock.EasyMock;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.cg.payroll.beans.Associate;
//import com.cg.payroll.beans.BankDetails;
//import com.cg.payroll.beans.Salary;
//import com.cg.payroll.daoservices.AssociateDAO;
//import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
//import com.cg.payroll.services.PayrollServices;
//import com.cg.payroll.services.PayrollServicesImpl;
//
//public class PayrollServicesTestEasyMock {
//	private static PayrollServices payrollServices;
//	private static AssociateDAO mockAssociateDao;
//
//	@BeforeClass
//	public static void setUpTestEnv() {
//		mockAssociateDao=EasyMock.mock(AssociateDAO.class);
//		payrollServices=new PayrollServicesImpl(mockAssociateDao);	
//	}
//
//	@Before
//	public void setUpTestMockData() {
//		Associate associate1=new Associate(333,555,"Analyst", "Staff","ghh","ytdyh", "ABT21JJ7", "vmunjal1@gmail.com", new Salary(150000, 125,5444), new BankDetails(12345, "fttg","gyh"));
//		Associate associate2=new Associate(335,553,"Analyst", "Staff","ghh","ytdyh", "ABT21JJ7", "vmunjal1@gmail.com", new Salary(150000, 125,5444), new BankDetails(1235, "ftg","jgg"));
//		Associate associate3=new Associate(555,"Analyst", "Staff","ghh","ytdyh", "ABT21JJ7", "vmunjal1@gmail.com", new Salary(150000, 125,5444), new BankDetails(12345, "fttg","gyh"));
//
//		ArrayList<Associate> associatesList=new ArrayList<>();                                    
//		associatesList.add(associate1);
//		associatesList.add(associate2);
//
//		EasyMock.expect(mockAssociateDao.save(associate3)).andReturn(associate3);
//
//		EasyMock.expect(mockAssociateDao.findOne(333)).andReturn(associate1);
//		EasyMock.expect(mockAssociateDao.findOne(335)).andReturn(associate2);
//		EasyMock.expect(mockAssociateDao.findOne(1234)).andReturn(null);//random
//		EasyMock.expect(mockAssociateDao.findAll()).andReturn(associatesList);
//		EasyMock.replay(mockAssociateDao);
//	}
//	@Test(expected= AssociateDetailsNotFoundException.class)
//	public void testGetAssociateDataForInvalidAssociateId() throws AssociateDetailsNotFoundException{
//		payrollServices.getAssociateDetails(1234);
//		EasyMock.verify(mockAssociateDao.findOne(1234));
//	}
//	@Test
//	public void testGetAssociateDataForValidAssociateId()
//			throws AssociateDetailsNotFoundException{
//		Associate expectedAssociate=new Associate(333,555,"Analyst", "Staff","ghh","ytdyh", "ABT21JJ7", "vmunjal1@gmail.com", new Salary(150000, 125,5444), new BankDetails(12345, "fttg","gyh"));
//		Associate actualAssociate=payrollServices.getAssociateDetails(333);
//		assertEquals(expectedAssociate,actualAssociate);
//		EasyMock.verify(mockAssociateDao.findOne(333));
//	}
//      @After
//      public void tearDownTestMockData() {
//    	  EasyMock.resetToDefault(mockAssociateDao);
//      }
//      @AfterClass
//      public static void  tearDownTestEnv() {
//    	  mockAssociateDao=null;
//    	  payrollServices=null;
//      }
//}
//
