package com.oop.service;

import java.util.List;

import com.oop.model.Employee;

public interface IEmployeeService {
	
	public void add_employee(Employee object);
	
	public List<Employee> all_employees();
	
	public List<Employee> new_employees();
	
	public Employee assign_department_emp(String emp_id);
	
	public void update_department(Employee object);
	
	public void delete_emp(String emp_id);

}
