package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
	/*
	private Connection connection;
	
	public ProductModel(Connection connection) {
		this.connection = connection;
	}
	
	public List<ProductDTO> getAllProducts(){
		List<ProductDTO> products = new ArrayList<>();
		String query = "SELECT * FROM products";
		
		try {
			PreparedStatement st = connection.prepareStatement(query);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				ProductDTO pro = new ProductDTO();
				pro.setProduct_id(result.getInt("product_id"));
				pro.setProductName(result.getString("product_name"));
				pro.setCategory(result.getString("category"));
				pro.setPrice(result.getDouble("price"));
				pro.setStock_quantity(result.getInt("stock_quantity"));
				products.add(pro);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return  products;
	}
	
	
	*/
	private static Connection connection;
	//Ŭ������ �ν��Ͻ��� �����ϴ� �̱��� ��ü
	private static ProductModel productModel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafe";
	private static String PW = "kh1234";
	
	//�⺻ �����ڷκ��� �ܺο��� �ν��Ͻ��� ���� �����ϴ� ���� �����ϱ� ���� private���� ����
	private ProductModel() {
			
	}
	//ProductModel Ŭ������ �ν��Ͻ��� ��ȯ�ϴ� �޼���
	//ó�� ȣ��� �� �����ͺ��̽��� ������ �����ϰ� ���� ȣ�⿡���� �̹� ������ �ν��Ͻ��� ��ȯ
	//�̱��� ������ �����ϴ� ���
	public static ProductModel getInstance() throws SQLException {
		if(productModel == null) {
			productModel = new ProductModel();
			connection = DriverManager.getConnection(DB_URL, ID, DB_URL);
			
		}
		return productModel;
	}
	
	public boolean insertProduct(ProductDTO product) {
		String sql = "INSERT INTO products (product_id, product_name, category, price, stock_quantity)"
					+"VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, product.getProduct_id());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getCategory());
			ps.setDouble(4, product.getPrice());
			ps.setInt(5, product.getStock_quantity());
			
			int rowsAffected = ps.executeUpdate();
			
			return rowsAffected > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}









