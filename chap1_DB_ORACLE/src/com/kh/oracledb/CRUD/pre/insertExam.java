package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//cafes insert �ۼ��ؼ� ���� ī�� �߰��ϱ�

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

            // SQL INSERT �� ����
            String insertSQL = "INSERT INTO cafes (cname, address, phone_number, operating_hours) VALUES (?, ?, ?, ?)";

            // PreparedStatement�� �����ϰ� ������ Ű(cafes ���̺��� cafe_id)�� �����ϴ� �� ����
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        //    PreparedStatement preparedStatement = connection.prepareStatement(insertSQL , new String[]{"cafe_id"});
            // INSERT ���� �ʿ��� ������ ����
            preparedStatement.setString(1, "d");
            preparedStatement.setString(2, "a");
            preparedStatement.setString(3, "c");
            preparedStatement.setString(4, "d �ð�");

            // ������ ����
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("�����Ͱ� ���������� ���ԵǾ����ϴ�.");
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int cafeId = generatedKeys.getInt(1);
                    System.out.println("������ cafe_id: " + cafeId);
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

            insertCafe(preparedStatement, "ī����", "�ּ� 1", "��ȭ��ȣ 1", "���� �ð� 1");
            insertCafe(preparedStatement, "ī�䰭��", "�ּ� 2", "��ȭ��ȣ 2", "���� �ð� 2");
            insertCafe(preparedStatement, "ī�伭��", "�ּ� 3", "��ȭ��ȣ 3", "���� �ð� 3");
            insertCafe(preparedStatement, "ī�俪��", "�ּ� 4", "��ȭ��ȣ 4", "���� �ð� 4");
            insertCafe(preparedStatement, "ī�����", "�ּ� 5", "��ȭ��ȣ 5", "���� �ð� 5");

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

        // ������ ����
        preparedStatement.executeUpdate();

    }

}
