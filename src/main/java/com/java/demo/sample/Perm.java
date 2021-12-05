package com.java.demo.sample;

import javax.persistence.Entity;

@Entity
public class Perm extends Emp {
	
	private String companyName;
	private double bonus;
	
	public Perm(int empId, String empName, String companyName, double bonus) {
		super(empId, empName);
		this.companyName = companyName;
		this.bonus = bonus;
	}
	public Perm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Perm(int empId, String empName) {
		super(empId, empName);
		// TODO Auto-generated constructor stub
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "Perm [companyName=" + companyName + ", bonus=" + bonus + "]";
	}
	
	
	
	
}
