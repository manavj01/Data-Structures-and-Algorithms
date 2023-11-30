package com.dsa.comvivaUdemyProjects.onlineShop.enteties.impl;


import com.dsa.comvivaUdemyProjects.onlineShop.enteties.Cart;
import com.dsa.comvivaUdemyProjects.onlineShop.enteties.Product;

public class DefaultCart implements Cart {

	// <write your code here>
	
	@Override
	public boolean isEmpty() {
		// <write your code here>
		
		return true;
	}

	@Override
	public void addProduct(Product product) {
		// <write your code here>
	}

	@Override
	public Product[] getProducts() {
		// <write your code here>
		
		return null;
	}

	@Override
	public void clear() {
		// <write your code here>
	}

}
