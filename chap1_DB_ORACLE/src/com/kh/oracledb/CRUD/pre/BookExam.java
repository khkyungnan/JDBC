package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookExam {

    public static void main(String[] args) {
        // 데이터베이스 연결 매개 변수
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "khcafe";
        String password = "kh1234";

        try {

            // 데이터베이스 연결 설정
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String insertQuery = "INSERT INTO book (book_id, title, author, publication_year, isbn, genre, description, price, publication_date, updated_date, is_available) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // 파라미터에 대한 값을 설정
            preparedStatement.setInt(1, 50); // book_id
            preparedStatement.setString(2, "위대한 KH"); // title
            preparedStatement.setString(3, "F. Scott Fitzgerald"); // author
            preparedStatement.setInt(4, 1925); // publication_year
            preparedStatement.setString(5, "978-0743273565"); // isbn
            preparedStatement.setString(6, "소설"); // genre
            preparedStatement.setString(7, "개발과 개발주의의 이야기입니다."); // description
            preparedStatement.setDouble(8, 12.99); // price

            // publication_date를 구문 분석하고 설정
            Date publicationDate = Date.valueOf("1936-01-01");
            preparedStatement.setDate(9, new Date(publicationDate.getTime()));

            preparedStatement.setNull(10, java.sql.Types.DATE); // updated_date (NULL로 설정)
            preparedStatement.setString(11, "Y"); // is_available

            // 삽입 문 실행
            preparedStatement.executeUpdate();

            // PreparedStatement 및 연결 닫기
            preparedStatement.close();
            connection.close();

            System.out.println("책 insert 저장");
        } catch ( SQLException  e) {
            e.printStackTrace();
        }
    }
}