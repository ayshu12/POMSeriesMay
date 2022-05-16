package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class ResultPage {

	private WebDriver driver;
	private ElementUtils eleUtils;
	
	private By searchHeader=By.xpath("//div[@id='content']/h1");
	private By searchResult=By.cssSelector("div.caption a");
	
	
	
	public ResultPage(WebDriver driver) {
		this.driver=driver;
		eleUtils=new ElementUtils(driver);
	}
	
	public String getSearchHeaderName() {
		return eleUtils.doGetText(searchHeader);
	}
   
	public int getSearchProductListCount() {
		return eleUtils.waitForElementsVisible(searchResult, Constants.DEFAULT_TIME_OUT).size();
	}
	
	public ProductInfoPage selectProduct(String mainProductName){
		List<WebElement> searchList=eleUtils.waitForElementsVisible(searchResult, Constants.DEFAULT_TIME_OUT);
		for(WebElement e:searchList) {
			String text=e.getText().trim();
//			System.out.println("productname:"+mainProductName);
//			System.out.println(text);
			if(text.equals(mainProductName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
}
