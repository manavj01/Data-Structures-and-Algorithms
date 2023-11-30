package com.dsa.comvivaUdemyProjects.onlineShop.services;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.Order;

public interface OrderManagementService {

	void addOrder(Order order);

	Order[] getOrdersByUserId(int userId);
	
	Order[] getOrders();

}
