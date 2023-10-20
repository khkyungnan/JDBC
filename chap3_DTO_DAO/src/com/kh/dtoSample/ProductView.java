package com.kh.dtoSample;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
	//��� �޼ҵ� void
	/*
	public void displayProducts(List<ProductDTO> products) {
		//���� for��
		for(ProductDTO  p : products) {
			System.out.println("Products ID : " + p.getProduct_id());
			System.out.println("Products Name : " + p.getProductName());
			System.out.println("Category : " + p.getCategory());
			System.out.println("Price : " + p.getPrice());
			System.out.println("Stock_quantity : " + p.getStock_quantity());
		}
		
	}
	 */
	public void addProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ��ǰ ������ �Է��ϼ���.");
		
		System.out.println("��ǰ ID : ");
		int productId = sc.nextInt();
		
		System.out.println("��ǰ �̸� : ");
		String productName = sc.next();
		
		System.out.println("ī�װ� : ");
		String category = sc.next();
		
		System.out.println("���� : ");
		double price = sc.nextDouble();
		
		System.out.println("������ : ");
		int stockQuantity = sc.nextInt();
		
		//Scanner�� ���� ��ǰ������ ���� �߰��ϱ�
		
		ProductDTO newProduct = new ProductDTO(productId,productName, category, price, stockQuantity);
		ProductModel productModel;
		
		boolean success = false;
		
		try {
			productModel = ProductModel.getInstance();
			success = productModel.insertProduct(newProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(success) {
			System.out.println("��ǰ�� ���������� �߰��Ǿ����ϴ�.");
		} else {
			System.out.println("��ǰ �߰� �� ������ �߻��߽��ϴ�.");
		}
		
		//��ĳ�� �ݱ�
		sc.close();
	}
	
	
}








