package com.cg.payroll.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.daoservices.AssociateDAOImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
@Component("payrollServices")
public class PayrollServicesImpl  implements PayrollServices{
	@Autowired

	private AssociateDAO associateDao;
	
	public int acceptAssociateDetails(String firstName, String lastName, String department, String designation,String pancard, String emailId, int yearlyInvestmentUnder80C, int accountNumber, String bankName,String ifscCode, int basicSalary, int epf, int companyPf) {
		//	BankDetails bankDetails=new BankDetails(accountNumber, bankName, ifscCode);
		//	 Salary salary=new Salary(basicSalary,  epf, companyPf);
		Associate associate=new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, new Salary(basicSalary, epf, companyPf), new BankDetails(accountNumber, bankName, ifscCode)); 
		associate=associateDao.save(associate);
		return associate.getAssociatedId();
		//	return associateDao.save(new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, new Salary(basicSalary, epf, companyPf), new BankDetails(accountNumber, bankName, ifscCode)));
	}
	@Override
	public double calculateNetSalary(int associateId) throws AssociateDetailsNotFoundException  {
		Associate associate=getAssociateDetails(associateId);
		Salary salary = salaryDetails(associate);
		double taxableAmount =(salary.getGrossSalary()-associate.getYearlyInvestmentUnder80C());
		salary.setMonthlyTax(calculateTax(associate, taxableAmount));
		double netSalary =  (taxableAmount - (salary.getMonthlyTax() + associate.getSalary().getEpf() + associate.getSalary().getCompanyPf() + associate.getYearlyInvestmentUnder80C()));
		associate.getSalary().setNetSalary(netSalary);
		associate.setSalary(salaryDetails(associate));
		associateDao.update(associate);
		return netSalary;
	}
	
	public double calculateTax(Associate associate, double taxableAmount) {
		double taxAmount =0;
		while(taxableAmount>250000) {
			if(taxableAmount>250000&&taxableAmount<=500000) {
				taxableAmount = taxableAmount - 250000;
				taxAmount = taxAmount+taxableAmount/10;		
			}
			if(taxableAmount>500000&&taxableAmount<=1000000) {
				taxableAmount=taxableAmount-500000;
				taxAmount =taxAmount+taxableAmount/20;
			}
			if(taxableAmount>1000000) {
				taxableAmount = taxableAmount-1000000;
				taxAmount=taxAmount+taxableAmount/30;
			}
		}
		System.out.println("mponthly tax: " + taxAmount);
		return taxAmount;
	}
	
	public Salary salaryDetails(Associate associate) {
		associate.getSalary().setHra((associate.getSalary().getBasicSalary()*30/100));
		associate.getSalary().setConveyenceAllowance((associate.getSalary().getBasicSalary()*30/100));
		associate.getSalary().setOtherAllowance((associate.getSalary().getBasicSalary()*35/100));
		associate.getSalary().setPersonalAllowance(associate.getSalary().getBasicSalary()/5);
		associate.getSalary().setGrossSalary(associate.getSalary().getBasicSalary()+associate.getSalary().getConveyenceAllowance()+associate.getSalary().getHra()+associate.getSalary().getOtherAllowance()+associate.getSalary().getPersonalAllowance());
		return associate.getSalary();
	}
	
	@Override
	public Associate getAssociateDetails(int associateId) throws AssociateDetailsNotFoundException {
		Associate associate=associateDao.findOne(associateId);
		if(associate==null)
			throw new AssociateDetailsNotFoundException("Associate details not found for id"+associateId);
		else
			return associate;
	}
	@Override
	public List<Associate> getAllAssociateDetails() {
		return associateDao.findAll();
	}
	@Override
	public double calculateAnnualGrossSalary(int associateId) throws AssociateDetailsNotFoundException {
		Associate associate=getAssociateDetails(associateId);
		return (associate.getSalary().getBasicSalary() +0.3*associate.getSalary().getBasicSalary()*2+0.25*associate.getSalary().getBasicSalary()+0.2*associate.getSalary().getBasicSalary()+associate.getSalary().getCompanyPf()+associate.getSalary().getEpf())*12;
	}
}