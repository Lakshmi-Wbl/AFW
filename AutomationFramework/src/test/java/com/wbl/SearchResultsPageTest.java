package com.wbl;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.pages.HomePage;
import com.wbl.pages.SearchResultsPage;

public class SearchResultsPageTest extends BaseTest{
	
	HomePage hm;
	SearchResultsPage sp;
	
		
	@Test(groups={"smoke"})
	public void clickSearchResultTest(){
		hm=new HomePage(driver);
		sp=hm.search("Laptop");
		
		Assert.assertTrue(sp.clickSearchResult(0).getTitle().contains("Windows"));
	}
	
	/*@Test
	public void maxPriceSortTest(){
		hm=new HomePage(driver);
		SearchResultsPage sp=hm.search("Laptop");
		sp.selectValuesFromSortDropDown("Price: high to low");
		Assert.assertEquals(sp.actualMaxPriceInSearchResults(),sp.maxPriceInSearchResults());
	}*/
	

}
