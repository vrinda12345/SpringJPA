package com.cg.payroll.services;

import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;

public interface PayrollServices {
int acceptAssociateDetails(String firstName,String lastName,String department,String designation,String pancard,String emailId,int yearlyInvestmentUnder80C,int accountNumber, String bankName,String ifscCode, int basicSalary,int epf,int companyPf);
double calculateNetSalary(int associateId)throws AssociateDetailsNotFoundException;
Associate getAssociateDetails(int associateId )throws AssociateDetailsNotFoundException;
double calculateAnnualGrossSalary(int associateId)throws AssociateDetailsNotFoundException;
List <Associate> getAllAssociateDetails( );
}