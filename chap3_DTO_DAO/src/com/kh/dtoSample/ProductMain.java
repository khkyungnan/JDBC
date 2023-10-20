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
			ProductView view = new ProductView();
			
			ProductController controller = new ProductController(con,view);
			
			controller.displayAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
