package com.dsa.comvivaUdemyProjects.onlineShop.services.impl;


import com.dsa.comvivaUdemyProjects.onlineShop.enteties.Order;
import com.dsa.comvivaUdemyProjects.onlineShop.services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

	private static final int DEFAULT_ORDER_CAPACITY = 10;

	private static DefaultOrderManagementService instance;

	// <write your code here>
	
	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@OverrideN
	public void addOrder(Order order) {
		// <write your code here>
	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		// <write your code here>
		return new Order[0];
	}

	@Override
	public Order[] getOrders() {
		// <write your code here>
		return null;
	}
	
	void clearServiceState() {
		// <write your code here>
	}

}
