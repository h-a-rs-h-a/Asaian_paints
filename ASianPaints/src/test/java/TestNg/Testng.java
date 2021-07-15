package TestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataProvider.ConfigFileReader;
import pageobjectmodel.Pom;

public class Testng {
	public WebDriver driver;
	Pom asianpaintWebElements;
	String baseUrl;
	ConfigFileReader configFileReader;
	
	@BeforeTest
	public void launchApp() {
		configFileReader=new ConfigFileReader();
		baseUrl=configFileReader.getApplicationUrl();
		ChromeOptions options = new ChromeOptions();
		
	    options.addArguments("--disable-notifications");
	    
		  System.out.println("before senario");
		  System.setProperty("webdriver.chrome.driver",configFileReader.getDriverPath());
		  driver =new ChromeDriver(options);
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
	      driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		  driver.get(baseUrl); 
		  asianpaintWebElements=new Pom(driver);
		
	}
	
  @Test(priority = 1)
  public void wallpaper() {
	  asianpaintWebElements.shop();
	  asianpaintWebElements.wallpapers();
  }
  @Test(priority = 2)
  public void sortBY() {
	
		asianpaintWebElements.sortBy();
  }
  @Test(priority = 3)
  public void wallPaperOftheYear() {
	 
		asianpaintWebElements.wOy();
  }
  @AfterTest
  public void closeApp() {
	  driver.quit();
  }
  
}
