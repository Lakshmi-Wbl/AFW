package com.wbl.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.wbl.base.CommonPage;
import com.wbl.utils.WebDriverWaitUtils;

public class SearchResultsPage extends CommonPage{
	
	@FindBy(how=How.CSS, using=".chooser-option-current")
	WebElement sortDropDown;

	@FindBy(how=How.CSS, using="[class$='chooser-option']")
	List<WebElement> sortDropDownValues;
	
	@FindBy(css=".price-main-block")
	List<WebElement> prices;
	
	@FindBy(css=".search-result-product-title.listview a")
	List<WebElement> searchTitleLinks;
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
	    PageFactory.initElements(driver, this);
	}
		
	public String selectValuesFromSortDropDown(String value){
		
		WebDriverWaitUtils.explicitWait(driver, 20, sortDropDown);
		sortDropDown.click();
		
		for(WebElement val: sortDropDownValues)
		{
			if(val.getText().equals(value)){
				val.click();
				break;
			}
		}
		prices=driver.findElements(By.cssSelector(".Price-characteristic"));
		
		return prices.get(0).getText();
	}
	
	public SearchResultDetailPage clickSearchResult(int index){
		//System.out.println(searchTitleLinks.get(index));
		searchTitleLinks.get(index).click();
		
		return new SearchResultDetailPage(driver);
	}
	
	public float findMax(List<WebElement> elements){

		float max=0;
		for(WebElement elm : elements){
				float price= Float.parseFloat(elm.getText().replaceAll("[^0-9].", ""));
				if(price>max){
					max=price;
				}
			}
			return max;
	}
	
	public float actualMaxPriceInSearchResults(){
		float price = Float.parseFloat(prices.get(0).getText().replaceAll("[^0-9].",""));
    	System.out.println(price);
		return price;
    }
    public float maxPriceInSearchResults(){
    	float max=0;
    	for(WebElement elm : prices){
    		//System.out.println(elm.getText());
    		float price = Float.parseFloat(elm.getText().replaceAll("[^0-9].",""));
    		if(price>max){
    			max=price;
    		}
    		 		
    	}
    	System.out.println(max);
    	return max;
    }
}
