package com.java.demo.sample;

import javax.persistence.Entity;

@Entity
public class Contract extends Emp{
	private String consultancyName;

	public Contract(int empId, String empName, String consultancyName) {
		super(empId, empName);
		this.consultancyName = consultancyName;
	}

	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contract(int empId, String empName) {
		super(empId, empName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Contract [consultancyName=" + consultancyName + "]";
	}

	public String getConsultancyName() {
		return consultancyName;
	}

	public void setConsultancyName(String consultancyName) {
		this.consultancyName = consultancyName;
	}
	
	
	
}
