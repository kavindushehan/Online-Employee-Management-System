package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.EmployeeServiceImpl;
import com.oop.service.IEmployeeService;

/**
 * Servlet implementation class DeleteEmployeeServlet
 */
@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emp_id = request.getParameter("emp_id");

		IEmployeeService ob = new EmployeeServiceImpl();
		ob.delete_emp(emp_id);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AllEmployee.jsp");
		dispatcher.forward(request, response);
	}

}
