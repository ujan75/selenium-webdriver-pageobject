package test;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.UptakePage;
import pages.ApproachPage;
import pages.CommonPage;

public class TestUptakePage {
  
	WebDriver driver;
	UptakePage uptakePage;
	ApproachPage approachPage;
	CommonPage commonPage;
	
	String expectedUptakeTitle = "Uptake – Analytics for the Industrial Internet";
	String expectedApproachTitle = "Approach – Uptake";
	String expectedPlatformTitle = "Platform – Uptake";
	
	@Test(priority=0)
	public void uptakePageTitleTest() {
		Assert.assertEquals(this.uptakePage.getUptakePageTitle(), this.expectedUptakeTitle);
	}

	@Test(priority=1)
	public void uptakePageLinkTest() {
				
		Assert.assertTrue(commonPage.checkLinkTextExists("Approach"));
		Assert.assertTrue(commonPage.checkLinkTextExists("Platform"));
		Assert.assertTrue(commonPage.checkLinkTextExists("Solutions"));
		Assert.assertTrue(commonPage.checkLinkTextExists("People"));
		Assert.assertTrue(commonPage.checkLinkTextExists("Join Us"));
		Assert.assertTrue(commonPage.checkLinkTextExists("Contact Us"));
		Assert.assertTrue(commonPage.checkLinkTextExists("Blog"));
	}
	
	@Test(priority=2)
	public void uptakePageNavigationTest() {
		
		commonPage.clickUptakeLogo();
		Assert.assertEquals(this.uptakePage.getUptakePageTitle(),this.expectedUptakeTitle);
		
		commonPage.clickLinkByText("Approach");
		Assert.assertEquals(this.uptakePage.getUptakePageTitle(),this.expectedApproachTitle);
		
		commonPage.clickLinkByText("Platform");
		Assert.assertEquals(this.uptakePage.getUptakePageTitle(),this.expectedPlatformTitle);
	}
	
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://www.uptake.com/");
		uptakePage = new UptakePage(driver);
		commonPage = new CommonPage(driver);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	
	}

}
