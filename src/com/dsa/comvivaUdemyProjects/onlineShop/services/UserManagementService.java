package com.dsa.comvivaUdemyProjects.onlineShop.services;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.User;

public interface UserManagementService {

	String registerUser(User user);
	
	User[] getUsers();

	User getUserByEmail(String userEmail);

}
