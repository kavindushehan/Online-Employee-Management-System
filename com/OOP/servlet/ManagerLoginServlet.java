package com.oop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.util.ManagerDBUtil;

@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password =  request.getParameter("password");
		
		ManagerDBUtil DB = new ManagerDBUtil();
		
		if(DB.check(username,password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			out.println("<script type='text/javascript'>");
			out.println("alert('You are Successfully Logged in');");
			out.println("location = 'ManagerView.jsp'");
			out.println("</script>");
			
		}
		
		else
		{
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location = 'ManagerLogin.jsp'");
			out.println("</script>");
			
		}
	}

}
