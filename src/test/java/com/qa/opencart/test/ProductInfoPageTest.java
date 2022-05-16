package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest{

	@BeforeClass
	public void productInfoPageSetup()
	{
		accpage= lp.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	
	@Test(priority=0)
	public void productHeaderTest() {
		resPage=accpage.doSearch("macbook");
		prodInfo=resPage.selectProduct("MacBook Pro");
		String actualHeader=prodInfo.getProductHeaderText();
		Assert.assertEquals(actualHeader,"MacBook Pro");
	}
	@DataProvider
	public Object[][] getImageData() {
		return new Object[][] {
			{"macbook","MacBook Pro",4},
			{"imac","iMac",3},
			{"apple","Apple Cinema 30\"",6}
		};
	}
	
	@Test(dataProvider = "getImageData" )
	public void productImageCount(String searchProduct,String productName,int imageCount) {
		resPage=accpage.doSearch(searchProduct);
		prodInfo=resPage.selectProduct(productName);
		int count=prodInfo.getProductImageCount();
		Assert.assertEquals(count,imageCount);
	}
	
	@Test
	public void productMEtaDataTest() {
		resPage=accpage.doSearch("macbook");
		prodInfo=resPage.selectProduct("MacBook Pro");
		Map<String,String> actProdMap=prodInfo.getProductMetaData();
		actProdMap.forEach((k,v)->System.out.println(k+ " : " +v));
		softAssert.assertEquals(actProdMap.get("Brand"), "Apple");
		softAssert.assertEquals(actProdMap.get("price"), "$2,000.00");
		softAssert.assertEquals(actProdMap.get("name"), "MacBook");
		softAssert.assertEquals(actProdMap.get("Product Code"), "Product 18");
		softAssert.assertAll();
	}
}
