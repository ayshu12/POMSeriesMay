package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterationPage;
import com.qa.opencart.pages.ResultPage;

public class BaseTest {

	public WebDriver driver;
	public DriverFactory df;
	public LoginPage lp;
	public Properties prop;
	public AccountsPage accpage;
	public RegisterationPage regpage;
	public ResultPage resPage;
	public ProductInfoPage prodInfo;
	
	public SoftAssert softAssert;
	
	@BeforeTest
	public void setUp() {
		df=new DriverFactory();
		prop=df.initProp();
		System.out.println("base:"+prop);
		driver=df.initDriver(prop);
		System.out.println("base driever:"+driver);
		lp=new LoginPage(driver);
		softAssert=new SoftAssert();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
