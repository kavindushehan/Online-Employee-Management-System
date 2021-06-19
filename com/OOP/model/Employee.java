package com.oop.model;

public class Employee {
	
	private int EmployeeID;
	private String Fname;
	private String Lname;
	private String Email;
	private String gender;
	private String dob;
	private String mobile;
	private String password;
	private String department;
	
	public int getEmployeeID() {
		return EmployeeID;
	}

	public String getFname() {
		return Fname;
	}

	public String getLname() {
		return Lname;
	}

	public String getEmail() {
		return Email;
	}

	public String getGender() {
		return gender;
	}
	
	public String getDOB() {
		return dob;
	}
	
	public String getMobile() {
		return mobile;
	}

	public String getPassword() {
		return password;
	}

	public String getDepartment() {
		return department;
	}
	
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setDOB(String dob) {
		this.dob = dob;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	

	

	
	
}
