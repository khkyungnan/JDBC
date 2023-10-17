package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
		insertBank();
	}
	
	static void selectBank() {
		
		//1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ����Ŭ �� ��ǻ�� ���� : ������ ���̽� ���� ����
		//                              ����IP�ּ�:port��ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		try {
			//������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");
			
			//SELECT ����
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			//result.next() : result ��ü���� ���� ��(row)���� �̵�
			//�������� ������ true ��ȯ, �׷��� ������ false
			while(result.next()) {
				// khbank�� �ִ� bank ���̺� ������տ��� account_id�� ������
				int accountID = result.getInt("account_id");
				//1. �Բ��غ��� :  accountNumber
				String accountNumber = result.getString("account_number");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				//2. �Բ��غ��� :  branchName
				String branchName = result.getString("branch_name");
				//3. java.sql import Date lastTransctionDate ��������
				Date lastTransactionDate = result.getDate("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + accountID + ", ACCOUNT_NAME : " + accountName+ ", BALANCE : " + balance
					+"ACCOUNT_NUMBER"+accountNumber+"BRANCH_NAME"+branchName+"LastTransactionDate : " +lastTransactionDate	);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void selectKhcafe() {
		//1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
				String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ����Ŭ �� ��ǻ�� ���� : ������ ���̽� ���� ����
		//                              ����IP�ּ�:port��ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		Connection con = null;
		//select * from menu �ۼ��ؼ� menu table ��������
	}

	static void selectIf() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			//where�� ����Ͽ� �����߰�
			String selectQuery = "SELECT * FROM BANK WHERE account_number in (?,?)";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			/*
			 /���⿡ ���ϴ� ������ account_id ����
			int targetAID = 2;

			//���� ����
			selectState.setInt(1, targetAID);
			 * */
			String[] targetAN = {"1234567890","5555666777"};
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			
			ResultSet result = selectState.executeQuery();
			
			//�� ���� ����
			if (!result.isBeforeFirst()) {
				System.out.println("�����ϴ� �����Ͱ� �����ϴ�.");
			}
			while (result.next()) {
				  int a = result.getInt("account_id");
		    	    String b = result.getString("account_number");
		    	    String c = result.getString("account_name");
		    	    double d = result.getDouble("balance");
		    	    String e = result.getString("branch_name");
		    	    Date f = result.getDate("last_transaction_date");
		    	    
		    	    System.out.println("ACCOUNT_ID : " + a + ", ACCOUNT_NAME : " + b + ", BALANCE : " + c
		    	            + " ACCOUNT_NUMBER " + d + " BRANCH_NAME " + e + " LastTransactionDate : " + f);
			
			} 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	static void insertBank() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String inserQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
								+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement insertState = con.prepareStatement(inserQuery);
			insertState.setInt(1, 14);
			insertState.setString(2, "16533219");
			insertState.setString(3, "�����");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5,  "kh");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row �߰���");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}











