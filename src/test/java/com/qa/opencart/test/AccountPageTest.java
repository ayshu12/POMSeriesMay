package com.qa.opencart.test;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;

@Epic("Epic 200:Open Cart app - Design Accounts page")
@Story("US 201: Accounts page features with some basic modules and functionality")
public class AccountPageTest extends BaseTest{

	@BeforeClass
   public void accPageSetup() {
	 System.out.println("Acc page:"+prop);
	  accpage= lp.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
   }
	
	@Test(priority=0)
	public void accPageTitleTest() {
		String title=accpage.accPageTitle();
		Assert.assertEquals(title,Constants.ACC_PAGE_TITLE);
	}
	
	@Test(priority=1)
	public void logoutButtonExistTest()
	{
		Assert.assertTrue(accpage.isLogoutLinkExist());
	}
	
	@Test(priority=2)
	public void searchFieldExistTest() {
		Assert.assertTrue(accpage.isSearchFieldExist());
	}
	
	@Test(priority=3)
	public void accoountSectionListTest() {
		List<String> accSectList=accpage.getAccoountSectionList();
		Assert.assertEquals(accpage.getAccoountSectionList(),Constants.EXP_ACCOUNTS_SECTIONS_LIST);
	}
	
	@DataProvider
	public Object[][] productSearchData() {
		return new Object[][] {
			{"macbook"},
			{"imac"},
			{"apple"}           
		};
	}
	@Test(dataProvider = "productSearchData" ,priority=4)
	public void SearchTest(String productName) {
		resPage=accpage.doSearch(productName);
		Assert.assertTrue(resPage.getSearchProductListCount()>0);
	}
	
	@DataProvider
	public Object[][] productSelectData() {
		return new Object[][] {
			{"macbook","MacBook Pro"},
			{"imac","iMac"},
			{"apple","Apple Cinema 30\""}
		};
	}
	@Test(dataProvider = "productSelectData" ,priority=5        )
	public void selectProductTest(String productName,String mainProductName) {
		resPage=accpage.doSearch(productName);
		resPage.selectProduct(mainProductName);
	}
	
}
