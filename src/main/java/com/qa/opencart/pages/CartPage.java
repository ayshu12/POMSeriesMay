package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class CartPage {

	private By cartButton= By.id("cart");
	public CartPage()
	{
		System.out.println("cart page....");
	}
	public void addToCart() {
		System.out.println("Add to cart");
		System.out.println("addd feature is done");
	}
}
