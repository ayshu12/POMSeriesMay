package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtils eleUtil;
	
	private By productHeadr=By.cssSelector("div#content h1");
	private By productImage=By.cssSelector("ul.thumbnails img");
	private By productQuantity=By.name("quantity");
	private By addToCartat=By.id("button-cart");
	private By productMetaData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	private By productPriceData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li");
	
	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtils(driver);
	}
	
	public String getProductHeaderText() {
		return eleUtil.doGetText(productHeadr);
	}
	
	public int getProductImageCount() {
		return eleUtil.waitForElementsVisible(productImage, 30).size();
	}
	
	public Map<String ,String>  getProductMetaData() {
		Map<String ,String> prodMap=new HashMap<String,String>();
		String productName=eleUtil.doGetText(productHeadr);
		prodMap.put("name", productName.trim());
		//System.out.println(productName.trim());
		getProdMetaData(prodMap);
		getProdPriceData(prodMap);
		return prodMap;
	}
	
	private void getProdMetaData(Map<String ,String> prodMap) {
		List<WebElement> metaList=eleUtil.getElements(productMetaData);
		for(WebElement e:metaList) {
			String text=e.getText();
			String metaKey=text.split(":")[0].trim();
			String metaValue=text.split(":")[1].trim();
			prodMap.put(metaKey, metaValue);
			
		}
	}
	
	private void getProdPriceData(Map<String ,String> prodMap) {
		List<WebElement> priceList=eleUtil.getElements(productPriceData);
		String actualPrice=priceList.get(0).getText().trim();
		String exTaxPrice=priceList.get(1).getText().trim();
		prodMap.put("price",actualPrice);
		prodMap.put("exTax", exTaxPrice.split(":")[1].trim());
	}
}
