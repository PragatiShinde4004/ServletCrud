package com.js.sc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value = "/update")
public class UpdateStage1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ProductCrud productCrud = new ProductCrud();
		Product product = productCrud.getProductById(id);
		if(product!=null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("update.jsp");
			req.setAttribute("pro", product);
			dispatcher.forward(req, resp);
		}else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("NO PRODUCT WITH GIVEN ID TO UPDATE");
		}
	}
}
