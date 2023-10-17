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
		
		//1. 드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. 오라클 내 컴퓨터 연결 : 데이터 베이스 연결 정보
		//                              나의IP주소:port번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		try {
			//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			
			//SELECT 쿼리
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			//result.next() : result 객체에서 다음 행(row)으로 이동
			//다음행이 있으면 true 반환, 그렇지 않으면 false
			while(result.next()) {
				// khbank에 있는 bank 테이블 결과집합에서 account_id를 가져옴
				int accountID = result.getInt("account_id");
				//1. 함께해보기 :  accountNumber
				String accountNumber = result.getString("account_number");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				//2. 함께해보기 :  branchName
				String branchName = result.getString("branch_name");
				//3. java.sql import Date lastTransctionDate 가져오기
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
		//1. 드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
				String driver = "oracle.jdbc.driver.OracleDriver";
		//2. 오라클 내 컴퓨터 연결 : 데이터 베이스 연결 정보
		//                              나의IP주소:port번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		Connection con = null;
		//select * from menu 작성해서 menu table 가져오기
	}

	static void selectIf() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			//where절 사용하여 조건추가
			String selectQuery = "SELECT * FROM BANK WHERE account_number in (?,?)";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			/*
			 /여기에 원하는 조건의 account_id 설정
			int targetAID = 2;

			//조건 설정
			selectState.setInt(1, targetAID);
			 * */
			String[] targetAN = {"1234567890","5555666777"};
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			
			ResultSet result = selectState.executeQuery();
			
			//값 존재 여부
			if (!result.isBeforeFirst()) {
				System.out.println("존재하는 데이터가 없습니다.");
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
}











