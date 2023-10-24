package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductController {
	private ProductDAO dao;
	
	public ProductController(ProductDAO dao) {
		this.dao = dao;
	}
	
	//총 가격 계산 메소드
	public double calculateTotalPrice() {
		
	}
	
	// 모든 제품 리스트
	public List<ProductDTO> getAllProducts(){
		return dao.getAllProducts();
	}
}






