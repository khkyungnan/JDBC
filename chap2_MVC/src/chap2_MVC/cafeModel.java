package chap2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe";
	String password = "kh1234";
	
	public void insertCafe(String name, String address, String phoneNumber, String operatingHours) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("연결성공!");
			String sql = "INSERT INTO cafes (name,address,phone_number, operating_hours) "
						+"VALUES( ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phoneNumber);
			ps.setString(4, operatingHours);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void UpdateCafe(int cafeId, String newOperatingHours) {
		String sql = "UPDATE cafes SET operating_hours = ? WHERE cafe_id = ?";
	}
	
	public void UpdateMenu(String description, int menuId, int cafeId) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE menu SET description = ? WHERE menu_id =? AND cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, description);
			st.setInt(2, menuId);
			st.setInt(3, cafeId);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}





