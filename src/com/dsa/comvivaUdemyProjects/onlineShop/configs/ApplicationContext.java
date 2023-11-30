package com.dsa.comvivaUdemyProjects.onlineShop.configs;

import com.dsa.comvivaUdemyProjects.onlineShop.enteties.Cart;
import com.dsa.comvivaUdemyProjects.onlineShop.enteties.User;
import com.dsa.comvivaUdemyProjects.onlineShop.enteties.impl.DefaultCart;
import com.dsa.comvivaUdemyProjects.onlineShop.menu.Menu;

public class ApplicationContext {
	private static ApplicationContext instance;
	
	private User loggedInUser;
	private Menu mainMenu;
	private Cart sessionCart;
	
	private ApplicationContext() {
	}
	
	public void setLoggedInUser(User user) {
		if (this.sessionCart != null) {
			this.sessionCart.clear(); // we have to clear session cart when new user is logged in
		}
		this.loggedInUser = user;
	}
	
	public User getLoggedInUser() {
		return this.loggedInUser;
	}
	
	public void setMainMenu(Menu menu) {
		this.mainMenu = menu;
	}
	
	public Menu getMainMenu() {
		return this.mainMenu;
	}

	public static ApplicationContext getInstance() {
		if (instance == null) {
			instance = new ApplicationContext();
		}
		return instance;
	}

	public Cart getSessionCart() {
		if (this.sessionCart == null) {
			this.sessionCart = new DefaultCart();
		}
		return this.sessionCart;
	}
}