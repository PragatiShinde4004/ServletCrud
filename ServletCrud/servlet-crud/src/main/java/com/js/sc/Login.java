package com.js.sc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value = "/login")
public class Login extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		if(email.equals("uday@mail.com") && password.equals("12345")) {
			Cookie cookie = new Cookie("email", email);
			resp.addCookie(cookie);
			resp.sendRedirect("welcome.jsp");
		}else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("Wrong credentials");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		}
	}
}
