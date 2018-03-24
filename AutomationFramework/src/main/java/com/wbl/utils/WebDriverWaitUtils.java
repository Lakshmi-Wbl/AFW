package com.wbl.utils;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class WebDriverWaitUtils {

	
static Logger log = LogManager.getLogger(WebDriverWaitUtils.class);
	
	public static WebElement explicitWait(WebDriver driver, long timeInSecs, WebElement element){
		try{
		WebDriverWait wait = new WebDriverWait(driver,timeInSecs);
		element = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e){
			log.error("Exception occured while waiting for the specific element expllicitly");
			log.error(e.getMessage());
		}
		return  element;
	}
	
	public static List<WebElement> explicitWait(WebDriver driver, long timeInSecs, List<WebElement> elements){
		try{
		WebDriverWait wait = new WebDriverWait(driver,timeInSecs);
		elements = wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		}catch(Exception e){
			log.error("Exception occured while waiting for the elements expllicitly");
			log.error(e.getMessage());
		}
		return  elements;
	}
	
	public static void implicitWait(WebDriver driver, long timeInSecs){
		driver.manage().timeouts().implicitlyWait(timeInSecs, TimeUnit.SECONDS);
	}

}


