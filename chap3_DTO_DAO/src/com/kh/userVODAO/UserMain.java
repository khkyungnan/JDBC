package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		//1. DB 연결 URL, USERNAME, PASSWORD
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("User ID : ");
			int userId = sc.nextInt();
			
			System.out.println("아이디를 입력 해주세요 : ");
			String userName = sc.next();
			
			System.out.println("회원가입이 거의다 끝났습니다.");
			System.out.println("마지막으로 이메일 작성해주세요. : ");
			String email = sc.next();
			
			Date regDate = new Date(); //현재 날짜와 시간을 사용한다는 의미
			
			//DB에 담기 위해 인스턴스 생성 후 작성받은 정보 저장하기
			UserVO newUser = new UserVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			//데이터가 정상적으로 들어갔는지 확인 boolean을 사용해서 확인
			if(userDao.createUser(newUser)) { //true
				System.out.println("유저가 성공적으로 등록되었습니다.");
			} else {						  //false
				System.out.println("유저 등록에 실패하였습니다.");
			}
			
			//연결 닫기
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}




