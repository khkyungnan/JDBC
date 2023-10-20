package com.kh.dtoSample;

import java.util.List;

public class ProductView {
	//출력 메소드 void
	public void displayProducts(List<ProductDTO> products) {
		//향상된 for문
		for(ProductDTO  p : products) {
			System.out.println("Products ID : " + p.getProduct_id());
			System.out.println("Products Name : " + p.getProductName());
			System.out.println("Category : " + p.getCategory());
			System.out.println("Price : " + p.getPrice());
			System.out.println("Stock_quantity : " + p.getStock_quantity());
		}
		
	}
}
