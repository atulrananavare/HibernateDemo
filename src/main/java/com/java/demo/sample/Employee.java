package com.java.demo.sample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_INFO")
public class Employee {					//mapping file---> employee.hbm.xml
	
	@Id
	@Column(name = "EMP_ID")
	private int empId;
	
	@Column(name = "EMP_NAME",nullable = false)	// not null
	private String empName;
	
	@Column(name = "EMP_EMAIL",unique = true,nullable = false) // every emp will get unique email address
	private String empEmail;
	
	@Column(name = "EMP_ROLE")
	private String empRole;
	
	@Column(name = "EMP_GENDER",updatable = false)	// once inserted cannot be changed.
	private String empGender;
	public Employee(int empId, String empName, String empEmail, String empRole, String empGender) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empRole = empRole;
		this.empGender = empGender;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empRole=" + empRole
				+ ", empGender=" + empGender + "]";
	}
	
	
	
	
	
	
}
