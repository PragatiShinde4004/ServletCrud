package com.js.sc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCrud {
	static String url = "jdbc:mysql://localhost:3307/servlet_crud";
	static String user = "root";
	static String password = "root";

	public int  saveProduct(Product p) {
		String query = "insert into product values (?,?,?,?,?)";
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getBrand());
			ps.setInt(4, p.getQuantity());
			ps.setDouble(5, p.getPrice());
			return ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public boolean deleteProduct(int id) {
		String query = "delete from product where id=?";
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, id);
			int a = ps.executeUpdate();
			if(a!=0) {
				return true;
			}
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public int updateProduct(int id, Product p) {
		ProductCrud pc = new ProductCrud();
		Product product = pc.getProductById(id);
		if (product!=null) {
			String query = "update product set name=?,brand=?,quantity=?,price=? where id=?";
			Connection c = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				c = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = c.prepareStatement(query);
				ps.setString(1, p.getName());
				ps.setString(2, p.getBrand());
				ps.setInt(3, p.getQuantity());
				ps.setDouble(4, p.getPrice());
				ps.setInt(5, id);
				return ps.executeUpdate();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			finally {
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("No product with given id");
		}
		return 0;
	}

	public Product getProductById(int id) {
		String query = "select * from product where id=?";
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setBrand(rs.getString(3));
				p.setQuantity(rs.getInt(4));
				p.setPrice(rs.getDouble(5));
				return p;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Product> getAllProduct() {
		String query = "select * from product";
		Connection c = null;
		List<Product> products = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = c.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setBrand(rs.getString(3));
				p.setQuantity(rs.getInt(4));
				p.setPrice(rs.getDouble(5));
				products.add(p);
			}
			return products;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return products;
	}

	public void batchExecution(List<Product> products) {
		String query = "insert into product values (?,?,?,?,?)";
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = c.prepareStatement(query);
			for (Product p : products) {
				ps.setInt(1, p.getId());
				ps.setString(2, p.getName());
				ps.setString(3, p.getBrand());
				ps.setInt(4, p.getQuantity());
				ps.setDouble(5, p.getPrice());
				
				ps.addBatch();
			}
			ps.executeBatch();
			System.out.println("Done");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
