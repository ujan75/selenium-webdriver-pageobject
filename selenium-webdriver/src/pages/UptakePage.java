package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class UptakePage {

	WebDriver driver;
	String baseUrl = "http://uptake.com";
	
	public UptakePage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getUptakePageTitle(){
		return driver.getTitle();
	}
	
}
