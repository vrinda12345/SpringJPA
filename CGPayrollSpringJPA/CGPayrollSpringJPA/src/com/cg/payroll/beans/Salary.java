package com.cg.payroll.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Salary{
	private int basicSalary,hra,conveyenceAllowance;
	private int otherAllowance,personalAllowance,epf;
	double monthlyTax;
	private int companyPf,grossSalary;
	double netSalary;
	public Salary() {}
	
	public Salary(int basicSalary, int hra, int conveyenceAllowance, int otherAllowance, int personalAllowance, int monthlyTax, int epf, int companyPf, int grossSalary, int netSalary) {
		super();
		this.basicSalary = basicSalary;
		this.hra = hra;
		this.conveyenceAllowance = conveyenceAllowance;
		this.otherAllowance = otherAllowance;
		this.personalAllowance = personalAllowance;
		this.monthlyTax = monthlyTax;
		this.epf = epf;
		this.companyPf = companyPf;
		this.grossSalary = grossSalary;
		this.netSalary = netSalary;
	}
	public Salary(int basicSalary, int epf, int companyPf) {
		super();
		this.basicSalary = basicSalary;
		this.epf = epf;
		this.companyPf = companyPf;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
	public int getHra() {
		return hra;
	}
	public void setHra(int hra) {
		this.hra = hra;
	}
	public int getConveyenceAllowance() {
		return conveyenceAllowance;
	}
	public void setConveyenceAllowance(int conveyenceAllowance) {
		this.conveyenceAllowance = conveyenceAllowance;
	}
	public int getOtherAllowance() {
		return otherAllowance;
	}
	public void setOtherAllowance(int otherAllowance) {
		this.otherAllowance = otherAllowance;
	}
	public int getPersonalAllowance() {
		return personalAllowance;
	}
	public void setPersonalAllowance(int personalAllowance) {
		this.personalAllowance = personalAllowance;
	}
	public double getMonthlyTax() {
		return monthlyTax;
	}
	public void setMonthlyTax(double d) {
		this.monthlyTax = d;
	}
	public int getEpf() {
		return epf;
	}
	public void setEpf(int epf) {
		this.epf = epf;
	}
	public int getCompanyPf() {
		return companyPf;
	}
	public void setCompanyPf(int companyPf) {
		this.companyPf = companyPf;
	}
	public int getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(int grossSalary) {
		this.grossSalary = grossSalary;
	}
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary2) {
		this.netSalary = netSalary2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		if (basicSalary != other.basicSalary)
			return false;
		if (companyPf != other.companyPf)
			return false;
		if (conveyenceAllowance != other.conveyenceAllowance)
			return false;
		if (epf != other.epf)
			return false;
		if (grossSalary != other.grossSalary)
			return false;
		if (hra != other.hra)
			return false;
		if (monthlyTax != other.monthlyTax)
			return false;
		if (netSalary != other.netSalary)
			return false;
		if (otherAllowance != other.otherAllowance)
			return false;
		if (personalAllowance != other.personalAllowance)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Salary [basicSalary=" + basicSalary + ", monthlyTax=" + monthlyTax + ", epf=" + epf + ", companyPf="+ companyPf + ", grossSalary=" + grossSalary + ", netSalary=" + netSalary + "]";
	}
}