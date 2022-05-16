package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100:Open Cart app - design login page")
@Story("US 101: Login page features with some basic modules and functionality")
public class LoginPageTest extends BaseTest{

	@Description("login page title....")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=lp.getLoginPageTitle();
		System.out.println("Actual page title: "+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("login page url....")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2)
	public void loginPageUrlTest() {
		String url=lp.getLoginPageUrl();
		System.out.println("Actual page url: "+url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_VALUE));
	}
	
	@Description("login page forgot password link test....")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=4)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(lp.isForgetPwdLinkExist());
	}
	
	@Description("login page registeration link test....")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3)
	public void registerLinkTest() throws Exception {
		Assert.assertTrue(lp.isRegisterLinkExist());
	}
	
	@Description("login page test....")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=5)
	public void loginTest() {
		System.out.println("login prop:"+prop);
		lp.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		
	}
}