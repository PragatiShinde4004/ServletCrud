package com.js.sc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value = "/register")
public class SaveProduct extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product p = new Product();
		p.setId(Integer.parseInt(req.getParameter("id")));
		p.setName(req.getParameter("name"));
		p.setBrand(req.getParameter("brand"));
		p.setPrice(Double.parseDouble(req.getParameter("price")));
		p.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		
		ProductCrud pc = new ProductCrud();
		int a = pc.saveProduct(p);
		PrintWriter printWriter = resp.getWriter();
		if(a>0) {
			printWriter.print("Product Saved");
		}else {
			printWriter.print("Product Not Saved");
		}
	}
}
