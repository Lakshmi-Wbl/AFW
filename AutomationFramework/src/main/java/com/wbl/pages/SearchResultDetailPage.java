package com.wbl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wbl.base.CommonPage;

public class SearchResultDetailPage extends CommonPage {

	public SearchResultDetailPage(WebDriver driver) {
		super(driver);
	    PageFactory.initElements(driver, HomePage.class);
		
	}
	@FindBy(css=".prod-HeroImage-image")
	WebElement image;
	
	public boolean isSearchImagePresent(){
		
		return image.isDisplayed();
		
	}
	

}
