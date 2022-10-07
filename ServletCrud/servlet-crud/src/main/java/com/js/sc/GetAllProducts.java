package com.js.sc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/view")
public class GetAllProducts extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("email")) {
					ProductCrud productCrud = new ProductCrud();
					List<Product> products = productCrud.getAllProduct();
					if (products.size() > 0) {
						RequestDispatcher dispatcher = req.getRequestDispatcher("getall.jsp");
						req.setAttribute("list", products);
						dispatcher.forward(req, resp);
					} else {
						PrintWriter printWriter = resp.getWriter();
						printWriter.print("NO PRODUCTS IN TABLE");
					}
				}
			}
		}else {
			resp.sendRedirect("login.html");
		}
	}
}
