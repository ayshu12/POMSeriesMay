package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class AccountsPage{

	private WebDriver driver;
	private ElementUtils eleUtils;
	
	//By locators
	private By search=By.name("search");
	private By accSection=By.cssSelector("#content>h2");
	private By logout=By.linkText("Logout");
	private By searchButton=By.xpath("//div[@id='search']/span/button");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleUtils=new ElementUtils(driver);
	}
	
	public String accPageTitle() {
		return eleUtils.waitForTitleToBe(Constants.DEFAULT_TIME_OUT,Constants.ACC_PAGE_TITLE);
	}
	
	public boolean isLogoutLinkExist()
	{
		return eleUtils.doIsDiplayed(logout);
	}
	
	public boolean isSearchFieldExist() {
		return eleUtils.doIsDiplayed(search);
	}
	
	public ResultPage doSearch(String productName) {
		eleUtils.doSendKeys(search, productName);
		eleUtils.doClick(searchButton);
		return new ResultPage(driver);
	}
	
	public List<String> getAccoountSectionList() {
		List<WebElement> sectionList=eleUtils.getElements(accSection);
		List<String> searchHeaderList=new ArrayList<String>();
		for(WebElement e:sectionList) {
			searchHeaderList.add(e.getText());
		}
		return searchHeaderList;
	} 

}
