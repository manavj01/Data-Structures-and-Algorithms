package com.dsa.comvivaUdemyProjects.onlineShop.enteties.impl;


import com.dsa.comvivaUdemyProjects.onlineShop.enteties.Product;

public class DefaultProduct implements Product {
	
	private int id;
	private String productName;
	private String categoryName;
	private double price;

	public DefaultProduct() {
	}
	
	public DefaultProduct(int id, String productName, String categoryName, double price) {
		// <write your code here>
	}

	@Override
	public String toString() {
		// <write your code here>
		return null;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}

	
}
