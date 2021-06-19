package com.oop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String Fname = request.getParameter("firstname");
		String Lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dateofbirth");
		String mobile = request.getParameter("mobile");
		String department = request.getParameter("department");

		Employee object = new Employee();
		object.setFname(Fname);
		object.setLname(Lname);
		object.setEmail(email);
		object.setGender(gender);
		object.setDOB(dob);
		object.setMobile(mobile);
		object.setDepartment(department);

		IEmployeeService obj = new EmployeeServiceImpl();

		obj.add_employee(object);
		
		out.println("<script type='text/javascript'>");
		out.println("alert('Employee Added Successfully');");
		out.println("location = 'AddEmployee.jsp'");
		out.println("</script>");
	}

}
