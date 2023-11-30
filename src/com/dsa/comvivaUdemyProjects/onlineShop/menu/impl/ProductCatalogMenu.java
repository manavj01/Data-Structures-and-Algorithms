package com.dsa.comvivaUdemyProjects.onlineShop.menu.impl;

import com.dsa.comvivaUdemyProjects.onlineShop.services.ProductManagementService;
import com.dsa.comvivaUdemyProjects.onlineShop.services.impl.DefaultProductManagementService;
import com.dsa.comvivaUdemyProjects.onlineShop.configs.ApplicationContext;
import com.dsa.comvivaUdemyProjects.onlineShop.menu.Menu;

public class ProductCatalogMenu implements Menu {

	private static final String CHECKOUT_COMMAND = "checkout";
	private ApplicationContext context;
	private ProductManagementService productManagementService;

	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
	}

	@Override
	public void start() {
		// <write your code here>
	}

	@Override
	public void printMenuHeader() {
		// <write your code here>	
	}

}
