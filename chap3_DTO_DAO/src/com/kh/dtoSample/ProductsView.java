package com.kh.dtoSample;

import java.util.List;

public class ProductsView {
	//출력 메소드 void
	public void displayProducts(List<ProductsDTO> products) {
		//향상된 for문
		for(ProductsDTO  p : products) {
			System.out.println("Products ID : " + p.getProduct_id());
			System.out.println("Products Name : " + p.getProductName());
			System.out.println("Category : " + p.getCategory());
			System.out.println("Price : " + p.getPrice());
			System.out.println("Stock_quantity : " + p.getStock_quantity());
		}
		
	}
}
