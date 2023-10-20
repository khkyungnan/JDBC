package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductMain {

	public static void main(String[] args) {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl, username, password);
			ProductsView view = new ProductsView();
			
			ProductsController controller = new ProductsController(con,view);
			
			controller.displayAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
