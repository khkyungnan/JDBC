package com.kh.dtoSample;

import java.util.List;

public class ProductsView {
	//��� �޼ҵ� void
	public void displayProducts(List<ProductsDTO> products) {
		//���� for��
		for(ProductsDTO  p : products) {
			System.out.println("Products ID : " + p.getProduct_id());
			System.out.println("Products Name : " + p.getProductName());
			System.out.println("Category : " + p.getCategory());
			System.out.println("Price : " + p.getPrice());
			System.out.println("Stock_quantity : " + p.getStock_quantity());
		}
		
	}
}
