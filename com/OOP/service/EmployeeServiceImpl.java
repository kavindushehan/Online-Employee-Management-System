package com.oop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.oop.model.Employee;
import com.oop.util.DBConnection;

public class EmployeeServiceImpl implements IEmployeeService {
	
	public static final Logger log = Logger.getLogger(EmployeeServiceImpl.class.getName());
	
	private static Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    @Override
    public void add_employee(Employee object){
		
		con = DBConnection.getConnection();
		try {
			String sql = "insert into employee (Fname,Lname,Email,gender,dob,mobile,department) values (?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, object.getFname());
			ps.setString(2, object.getLname());
			ps.setString(3, object.getEmail());
			ps.setString(4, object.getGender());
			ps.setString(5, object.getDOB());
			ps.setString(6, object.getMobile());
			ps.setString(7, object.getDepartment());
			
			ps.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    
    
    @Override
	public List<Employee> all_employees(){
		
		con = DBConnection.getConnection();
		
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			String sql = "Select * from employee";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			
			while(rs.next()) {
				
				Employee emp = new Employee();
				
				emp.setEmployeeID(rs.getInt("EmployeeID"));
				emp.setFname(rs.getString("Fname"));
				emp.setLname(rs.getString("Lname"));
				emp.setEmail(rs.getString("Email"));
				emp.setGender(rs.getString("gender"));
				emp.setDOB(rs.getString("dob"));
				emp.setMobile(rs.getString("mobile"));
				emp.setDepartment(rs.getString("department"));
				
				list.add(emp);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	@Override
	public List<Employee> new_employees(){
		
		con = DBConnection.getConnection();
		
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			String sql = "Select * from employee where department=''";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			
			while(rs.next()) {
				
				Employee emp = new Employee();
				
				emp.setEmployeeID(rs.getInt("EmployeeID"));
				emp.setFname(rs.getString("Fname"));
				emp.setLname(rs.getString("Lname"));
				emp.setEmail(rs.getString("Email"));
				emp.setGender(rs.getString("gender"));
				emp.setDOB(rs.getString("dob"));
				emp.setMobile(rs.getString("mobile"));
				emp.setDepartment(rs.getString("department"));
				
				list.add(emp);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	@Override
	public Employee assign_department_emp(String emp_id){
		
		con = DBConnection.getConnection();
		Employee emp = new Employee();
		try {
			String sql = "Select * from employee where EmployeeID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, emp_id);
			rs=ps.executeQuery();			
			while(rs.next()) {
				emp.setEmployeeID(rs.getInt("EmployeeID"));
				emp.setFname(rs.getString("Fname"));
				emp.setLname(rs.getString("Lname"));
				emp.setEmail(rs.getString("Email"));
				emp.setGender(rs.getString("gender"));
				emp.setDOB(rs.getString("dob"));
				emp.setMobile(rs.getString("mobile"));
				emp.setDepartment(rs.getString("department"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
		
	}
    
    @Override
    public void update_department(Employee object){
		
		con = DBConnection.getConnection();
		try {
			String sql = "Update employee set Fname=?, Lname=?, Email=?, gender=?, dob=?, mobile=?, department=? where EmployeeID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, object.getFname());
			ps.setString(2, object.getLname());
			ps.setString(3, object.getEmail());
			ps.setString(4, object.getGender());
			ps.setString(5, object.getDOB());
			ps.setString(6, object.getMobile());
			ps.setString(7, object.getDepartment());
			ps.setInt(8, object.getEmployeeID());
			
			ps.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    
    @Override
    public void delete_emp(String emp_id){
		
		con = DBConnection.getConnection();
		
		try {
			String sql = "Delete from employee where EmployeeID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, emp_id);
			ps.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


}
