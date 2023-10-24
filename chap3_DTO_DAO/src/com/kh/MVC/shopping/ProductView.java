package com.kh.MVC.shopping;

import java.util.List;

public class ProductView {
	public void showProductList(List<ProductDTO> products) {
		for(ProductDTO p : products) {
			System.out.print("제품명 :     " + "     가격 : " );
			System.out.println(p.getProduct_name() + p.getPrice());
			System.out.println("================");
		}
	}
	
	//제품 최종 가격 메소드
	public void showTotalPrice(double totalPrice) {
		System.out.println("총 가격 : " + totalPrice);
	}
}






