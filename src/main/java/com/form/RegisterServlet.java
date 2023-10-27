package com.form;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("Text/html");
		PrintWriter outPrintWriter = resp.getWriter();
		outPrintWriter.println("Welcome to Register Servlet");
		
		String name = req.getParameter("user_name");
		String password = req.getParameter("user_password");
		String email = req.getParameter("user_email");
		String gender = req.getParameter("user_gender");
		String course = req.getParameter("user_course");
		String cond = req.getParameter("condition");
		
		if(cond != null) {
			outPrintWriter.println("<h2>Name: "+name+"</h2>");
			outPrintWriter.println("<h2>Password: "+password+"</h2>");
			outPrintWriter.println("<h2>Email: "+email+"</h2>");
			outPrintWriter.println("<h2>Gender: "+gender+"</h2>");
			outPrintWriter.println("<h2>Course: "+course+"</h2>");
			
			// saved to DB(RequestDispatcher Forward)
//			RequestDispatcher rDispatcher = req.getRequestDispatcher("success");
//			rDispatcher.forward(req, resp);
		}else {
			outPrintWriter.println("<h2>You Have Not Accepted Terms&Condition</h2>");
			
//			Include using RequestDispatcher
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
		
	}
}
