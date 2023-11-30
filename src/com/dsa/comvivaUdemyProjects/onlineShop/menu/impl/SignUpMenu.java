package com.dsa.comvivaUdemyProjects.onlineShop.menu.impl;


import com.dsa.comvivaUdemyProjects.onlineShop.configs.ApplicationContext;
import com.dsa.comvivaUdemyProjects.onlineShop.menu.Menu;
import com.dsa.comvivaUdemyProjects.onlineShop.services.UserManagementService;
import com.dsa.comvivaUdemyProjects.onlineShop.services.impl.DefaultUserManagementService;

public class SignUpMenu implements Menu {

	private UserManagementService userManagementService;
	private ApplicationContext context;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
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
