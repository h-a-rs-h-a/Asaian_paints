package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom {
	
public WebDriver driver;
	
	@CacheLookup
	
	@FindBy(xpath="//*[@id=\'headerNav\']/div[1]/ul/li[6]") WebElement Shop;
	@FindBy(xpath="//*[@name=\'SHOP\']") WebElement Wallpapers;
	@FindBy(xpath="//*[text()='filterBy']") WebElement Filter_By;
	@FindBy(xpath="//*[@class='reds']") WebElement Reds;
	
	@FindBy(xpath="//*[@id='prodListing']/section/div[2]/div/div[1]/div[1]/div/button[1]") WebElement Clear_All;
	
	@FindBy(xpath="//*[@name=\'sortBy\']") WebElement Sort_By;
	//*[@name="sortBy"]
	
	@FindBy(xpath="//a[@href='https://www.asianpaints.com/products/wall-coverings/jaipur-gemini-W150Z680S75.html']") WebElement WOY;
	
	public Pom(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void shop(){
		Actions actions=new Actions(driver);
		org.openqa.selenium.interactions.Action moveToShop=actions.moveToElement(Shop).build();
		moveToShop.perform();
	}
	
	public void wallpapers(){
		Wallpapers.click();
	}
	public void filterBy(){
		Filter_By.click();
	}
	public void red_S(){
		Reds.click();
	}
	public void clearAll(){
		Clear_All.click();
	}
	public void sortBy(){
		Sort_By.click();
	}

	public void wOy(){
		WOY.click();
	}

}
