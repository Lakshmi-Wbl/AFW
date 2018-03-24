package com.wbl.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.wbl.utils.ConfigUtils;
import com.wbl.utils.Constants;
import com.wbl.utils.ScreenshotUtils;
import com.wbl.utils.WebDriverUtil;


public class BaseTest {

	protected WebDriver driver;
	protected static String url;
	protected static String browser;
	static Logger log= LogManager.getLogger(BaseTest.class);
	
	@BeforeSuite
	public void beforeSuite(){
		ConfigUtils configUtils=new ConfigUtils(Constants.RESOURCES_PATH+"config.properties"); 
	    url=configUtils.getProperty("stageUrl");
		browser=configUtils.getProperty("browser");
	}
	
	
	/*@BeforeTest
	public void beforTest(){
		log.info("Test execution starts");
	}*/
	
	@BeforeMethod
	public void beforeMethod(){
		driver= WebDriverUtil.getDriver(browser);
		driver.get(url);
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		
	}
	@AfterMethod
	public void afterMethod(ITestResult rs){
		log.info(" rs test case name after every method:"+ rs.getName());
		if(ITestResult.FAILURE==rs.getStatus()){
			ScreenshotUtils.takeScreenShot(rs.getName(), driver);
		}
		driver.quit();
	}
}
