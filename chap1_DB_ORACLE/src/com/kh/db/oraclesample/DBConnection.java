package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
		
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

}















