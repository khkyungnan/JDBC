package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductController {
	private ProductDAO dao;
	
	public ProductController(ProductDAO dao) {
		this.dao = dao;
	}
	
	//�� ���� ��� �޼ҵ�
	public double calculateTotalPrice() {
		
	}
	
	// ��� ��ǰ ����Ʈ
	public List<ProductDTO> getAllProducts(){
		return dao.getAllProducts();
	}
}






