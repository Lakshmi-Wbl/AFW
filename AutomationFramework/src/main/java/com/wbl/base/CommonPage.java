package com.wbl.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.wbl.pages.HomePage;
import com.wbl.pages.SearchResultsPage;

public class CommonPage {
	
	protected WebDriver driver;
	
	@FindBy(how=How.ID,using="global-search-input")
	WebElement searchBox;
	
	@FindBy(how=How.CSS,using=".header-GlobalSearch-submit.btn")
	WebElement searchButton;
	
	@FindBy(how=How.CSS,using=".header-GlobalEyebrowNav.text-right.font-semibold")
	List<WebElement> navLinks;
	
	
	
	public CommonPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	public String getTitle(){
		return driver.getTitle();
	}
	
	/*public SearchResultsPage search(String searchdata){
		searchBox.sendKeys(searchdata);
		searchButton.click();
		return new SearchResultsPage(driver);
		
	}*/
    
	public int headerNavLinks(){
		return navLinks.size();
	}
	
	public void headerModalDropDowns(){
		List<WebElement> elements=driver.findElements(By.cssSelector(".flowtip-flyout-modal.flowtip-flyout-modal-bottom"));
		Actions action=new Actions(driver);
		for(WebElement ele: elements)
		{
			action.moveToElement(ele).perform();
			System.out.println(ele.getText());
		}
	}
	public int footerLinks(){
		return driver.findElements(By.cssSelector("")).size();
	}
}
