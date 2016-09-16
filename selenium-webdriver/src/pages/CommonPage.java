package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CommonPage {

	WebDriver driver;
	
	public CommonPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkLinkTextExists(String linkText){
		boolean test = false;
		try {
			   driver.findElement(By.linkText(linkText));
			   test = true;
		} catch (NoSuchElementException e) {
			   test = false;
		}
		return test;
	}
	
	public void clickLinkByText(String linkText){
		driver.findElement(By.linkText(linkText)).click();
	}

	public void clickUptakeLogo(){
		driver.findElement(By.cssSelector("a[href='/']")).click();
	}
	
}
