package com.kh.MVC.shopping;

import java.util.List;

public class ProductView {
	public void showProductList(List<ProductDTO> products) {
		for(ProductDTO p : products) {
			System.out.print("��ǰ�� :     " + "     ���� : " );
			System.out.println(p.getProduct_name() + p.getPrice());
			System.out.println("================");
		}
	}
	
	//��ǰ ���� ���� �޼ҵ�
	public void showTotalPrice(double totalPrice) {
		System.out.println("�� ���� : " + totalPrice);
	}
}






