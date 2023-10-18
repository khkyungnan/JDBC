package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//cafes insert 작성해서 여러 카페 추가하기

public class insertExam {
	 public static void main(String[] args) {
		 insertAllone();
		 insertALLTwo();
	 }
    static void insertAllone() {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "khcafe";
        String password = "kh1234";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // SQL INSERT 문 정의
            String insertSQL = "INSERT INTO cafes (cname, address, phone_number, operating_hours) VALUES (?, ?, ?, ?)";

            // PreparedStatement를 생성하고 생성된 키(cafes 테이블의 cafe_id)를 포함하는 열 지정
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        //    PreparedStatement preparedStatement = connection.prepareStatement(insertSQL , new String[]{"cafe_id"});
            // INSERT 문에 필요한 데이터 설정
            preparedStatement.setString(1, "d");
            preparedStatement.setString(2, "a");
            preparedStatement.setString(3, "c");
            preparedStatement.setString(4, "d 시간");

            // 데이터 삽입
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("데이터가 성공적으로 삽입되었습니다.");
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int cafeId = generatedKeys.getInt(1);
                    System.out.println("생성된 cafe_id: " + cafeId);
                }
                generatedKeys.close();
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void insertALLTwo() {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "khcafe";
        String password = "kh1234";
        String insertSQL = "INSERT INTO cafes (cname, address, phone_number, operating_hours) VALUES (?, ?, ?, ?)";

       
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

            insertCafe(preparedStatement, "카페써울", "주소 1", "전화번호 1", "영업 시간 1");
            insertCafe(preparedStatement, "카페강남", "주소 2", "전화번호 2", "영업 시간 2");
            insertCafe(preparedStatement, "카페서초", "주소 3", "전화번호 3", "영업 시간 3");
            insertCafe(preparedStatement, "카페역삼", "주소 4", "전화번호 4", "영업 시간 4");
            insertCafe(preparedStatement, "카페논현", "주소 5", "전화번호 5", "영업 시간 5");

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCafe(PreparedStatement preparedStatement, String name, String address, String phone, String hours) throws SQLException {
    
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, address);
        preparedStatement.setString(3, phone);
        preparedStatement.setString(4, hours);

        // 데이터 삽입
        preparedStatement.executeUpdate();

    }

}
