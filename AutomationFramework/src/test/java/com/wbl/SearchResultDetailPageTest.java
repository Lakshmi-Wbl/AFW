package com.wbl;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.pages.HomePage;
import com.wbl.pages.SearchResultDetailPage;
import com.wbl.pages.SearchResultsPage;

public class SearchResultDetailPageTest extends BaseTest{
	
	HomePage hm;
	SearchResultsPage sp;
	SearchResultDetailPage sdp;
	
	
	
	@Test
	public void imagePresentTest(){
		hm=new HomePage(driver);
		sp=hm.search("Laptop");
		sdp = sp.clickSearchResult(0);
		Assert.assertTrue(sdp.isSearchImagePresent());
	}
}
