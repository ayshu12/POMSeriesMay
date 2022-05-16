package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class RegisterationPage {

	private WebDriver driver;
	private ElementUtils eleUtils;
	
	//by locators
	private By fname=By.id("input-firstname");
	private By lname=By.id("input-lastname");
	private By email=By.id("input-email");
	private By telPhone=By.id("input-telephone");
	private By address=By.id("input-address-1");
	private By city=By.id("input-city");
	private By postcode=By.id("input-postcode");
	private By country=By.id("input-country");
	private By region=By.id("input-zone");
	private By password=By.id("input-password");
	private By confirmPwd=By.id("input-confirm");
	private By subcribeYes=By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subcribeNo=By.xpath("(//label[@class='radio-inline'])[position()=2]/input");
	private By privacypolicy=By.xpath("//input[@name='agree']");
	private By continueButton=By.xpath("//input[@type='submit']");
	private By accountRegistered=By.xpath("//div[@id='content']/h1");
	private By logout=By.linkText("Logout");
	private By registerLink=By.linkText("Register");
	
	public RegisterationPage(WebDriver driver) {
		this.driver=driver;
		eleUtils=new ElementUtils(driver);
	}
	
	public boolean registeration(String fname,String lname ,String email,String telPhone,String address,String city,String postcode,
			String country,String region,String password,String subscribe) {
		
		fillRegForm(fname, lname, email, telPhone, address, city, postcode, country, region, password);
		selectSubcritionOption(subscribe);
		selectAgreementANdCOntinue();
		return getRegisterationStatus();
	}
	
	private boolean getRegisterationStatus() {
		String msg= eleUtils.doGetText(accountRegistered);
		if(msg.contains(Constants.REGISTER_SUCCESS_MESSAGE)) {
			eleUtils.doClick(logout);
			eleUtils.doClick(registerLink);
			return true;
		}else
		{
			return false;
		}
	}
	
	private void selectAgreementANdCOntinue() {
		eleUtils.doClick(privacypolicy);
		eleUtils.doClick(continueButton);
	}
	private void selectSubcritionOption(String subscribe) {
		if(subscribe.equalsIgnoreCase("yes")) {
			eleUtils.doClick(subcribeYes);
		}else
		{
			eleUtils.doClick(subcribeNo);
		}
	}
	private void fillRegForm(String fname,String lname ,String email,String telPhone,String address,String city,String postcode,
			String country,String region,String password) {
		eleUtils.doSendKeys(this.fname,fname);
		eleUtils.doSendKeys(this.lname, lname);
		eleUtils.doSendKeys(this.email, email);
		eleUtils.doSendKeys(this.telPhone, telPhone);
		eleUtils.doSendKeys(this.address,address);
		eleUtils.doSendKeys(this.city, city);
		eleUtils.doSendKeys(this.postcode, postcode);
		eleUtils.doSelectDropDown(this.country,country);
		eleUtils.doSelectDropDown(this.region,region);
		eleUtils.doSendKeys(this.password, password);
		eleUtils.doSendKeys(this.confirmPwd,password);
	}

	
}
