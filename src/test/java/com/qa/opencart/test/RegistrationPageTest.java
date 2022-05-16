package com.qa.opencart.test;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtils;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass
	public void setupRegistrationPage() {
		regpage=lp.clickRegisterLink();
	}

//	public String getRandomNumber() {
//		Random random=new Random();
//		String email="test"+random.nextInt(200)+"@gmail.com";
//		return email;
//		
//	}
	@DataProvider
	public Object[][] getRegTestData() {
		Object[][] data=ExcelUtils.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
	}
	
	@Test(dataProvider = "getRegTestData" , priority=2)
	public void registrationTest(String fname,String lname ,String email,String telPhone,String address,String city,String postcode,
			String country,String region,String password,String subscribe) {
		Assert.assertTrue(regpage.registeration( fname, lname,email,telPhone, address,city, postcode,
				 country, region, password, subscribe));
	}
}
