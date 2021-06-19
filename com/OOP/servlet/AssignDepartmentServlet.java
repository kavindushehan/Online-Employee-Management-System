package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Employee;
import com.oop.service.EmployeeServiceImpl;
import com.oop.service.IEmployeeService;

/**
 * Servlet implementation class AssignDepartmentServlet
 */
@WebServlet("/AssignDepartmentServlet")
public class AssignDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int emp_id = Integer.parseInt(request.getParameter("employee_id"));
		String Fname = request.getParameter("firstname");
		String Lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dateofbirth");
		String mobile = request.getParameter("mobile");
		String department = request.getParameter("department");

		Employee object = new Employee();
		object.setEmployeeID(emp_id);
		object.setFname(Fname);
		object.setLname(Lname);
		object.setEmail(email);
		object.setGender(gender);
		object.setDOB(dob);
		object.setMobile(mobile);
		object.setDepartment(department);

		IEmployeeService obj = new EmployeeServiceImpl();

		obj.update_department(object);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AllEmployee.jsp");
		dispatcher.forward(request, response);
	}

}
