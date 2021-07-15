package stepdefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import dataProvider.ConfigFileReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.Pom;

public class StepDefinitions {
	
	WebDriver driver;
	Pom asianpaintWebElements;
	String baseUrl;
	ConfigFileReader configFileReader;
	
	//launching the application
	
	@Before
	public void lanchApplication() throws IOException 
	{  
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
	
	//wallpaper
	
	@Given("user is on the home page of asian paints")
	public void user_is_on_the_home_page_of_asian_paints() {
	    
	}

	@When("user clicks on shop icon")
	public void user_clicks_on_shop_icon() {
		asianpaintWebElements.shop();
	    
	}

	@Then("user can choose wallpapers by clicking on wallpapers icon")
	public void user_can_choose_wallpapers_by_clicking_on_wallpapers_icon() {
	   
	    asianpaintWebElements.wallpapers();
	}
	
	//filter
	
	@Given("user is on the wallpapers page")
	public void user_is_on_the_wallpapers_page() {
		//asianpaintWebElements.shop();
		//asianpaintWebElements.wallpapers();
	   
	}

	@When("user clicks on the color filter")
	public void user_clicks_on_the_color_filter() {
		
		//asianpaintWebElements.filterBy();
		
		
	}

	@Then("user can select desired color")
	public void user_can_select_desired_color() {
		//asianpaintWebElements.red_S();
	}

	@Then("user clicks on clear all to erase the applied filters")
	public void user_clicks_on_clear_all_to_erase_the_applied_filters() {
		//asianpaintWebElements.clearAll();
	}
	
	//sortBy
	@When("user clicks on the sortBy")
	public void user_clicks_on_the_sortBy() {
		asianpaintWebElements.shop();
		asianpaintWebElements.wallpapers();
		asianpaintWebElements.sortBy();
	}

	@Then("user can select desired option")
	public void user_can_select_desired_option() {
	    
	}
	
	//wallpaper of the year
	@When("user clicks on explore wallpaper of the year")
	public void user_clicks_on_explore_wallpaper_of_the_year() {
		asianpaintWebElements.shop();
		asianpaintWebElements.wallpapers();
		
	}

	@Then("user can see wallpaper of the year")
	public void user_can_see_wallpaper_of_the_year() {
		asianpaintWebElements.wOy();
	}









}
