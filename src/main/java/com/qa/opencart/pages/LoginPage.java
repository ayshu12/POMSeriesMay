package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.opencart.utils.ElementUtils;

import io.qameta.allure.Step;

public class LoginPage{
	private WebDriver driver;
	private ElementUtils eleUtils;
	
	//1.By locator
	private By email=By.id("input-email");
	private By password=By.id("input-password");
	private By loginButton=By.cssSelector("input[type='submit']");
	private By forgottenPwdLink= By.linkText("Forgotten Password");
	private By registerLink=By.linkText("Register");
	
	
	//2.page constructor:
	public LoginPage(WebDriver driver) {
		System.out.println("login driver:"+driver);
		this.driver=driver;
		eleUtils=new ElementUtils(driver);
	}
	
	//3.page actions/methods/features
	@Step("getting login page title....")
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	@Step("getting login page url....")
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
	
	@Step("getting login page forgot password exist....")
	public boolean isForgetPwdLinkExist() {
		System.out.println("Checcking forgot password exis t or not");
		return eleUtils.doIsDiplayed(forgottenPwdLink);
	}
	
	@Step("getting login page registeration link exist....")
	public boolean isRegisterLinkExist() {
		return eleUtils.doIsDiplayed(registerLink);
	}
	
	@Step("login with username :{0} and passowrd:{1}")
	public AccountsPage doLogin(String un,String pwd) {
		eleUtils.doSendKeys(email, un);
		eleUtils.doSendKeys(password, pwd);
		eleUtils.doClick(loginButton);
		return new AccountsPage(driver);
	}
	
	@Step("navigating to registeration page....")
	public RegisterationPage clickRegisterLink() {
		eleUtils.doClick(registerLink);
		return new RegisterationPage(driver);
	}
}
