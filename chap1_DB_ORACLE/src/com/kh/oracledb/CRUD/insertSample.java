package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertSample {

	public static void main(String[] args) {
		insertOne();
	}
	
	static void insertOne() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String inserQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
								+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement insertState = con.prepareStatement(inserQuery);
			insertState.setInt(1, 14);
			insertState.setString(2, "16533219");
			insertState.setString(3, "사아자");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5,  "kh");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row 추가됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void insertKhcafe() {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "khcafe";
			String password = "kh1234";
			
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				//insert 문 작성해보기
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//
	}
}











