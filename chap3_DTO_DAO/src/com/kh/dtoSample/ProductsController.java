package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

public class ProductsController {
	private ProductModel productModel;
	private ProductsView productView;
	
	public ProductsController(Connection connection, ProductsView view) {
		this.productModel = new ProductModel(connection);
		this.productView = view;
	}
	
	public void displayAllProducts() {
		List<ProductsDTO> products = productModel.getAllProducts();
		productView.displayProducts(products);
	}
}







