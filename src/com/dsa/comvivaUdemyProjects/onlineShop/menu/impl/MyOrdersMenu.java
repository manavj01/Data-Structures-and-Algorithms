package com.dsa.comvivaUdemyProjects.onlineShop.menu.impl;

import com.dsa.comvivaUdemyProjects.onlineShop.configs.ApplicationContext;
import com.dsa.comvivaUdemyProjects.onlineShop.menu.Menu;
import com.dsa.comvivaUdemyProjects.onlineShop.services.OrderManagementService;
import com.dsa.comvivaUdemyProjects.onlineShop.services.impl.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
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
