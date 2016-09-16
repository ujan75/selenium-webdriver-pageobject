package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ApproachPage {

	WebDriver driver;
	String baseUrl = "http://uptake.com/approach";

	public ApproachPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getApproachPageTitle(){
		return driver.getTitle();
	}
	
}
