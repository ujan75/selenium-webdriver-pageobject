package test;

import org.testng.annotations.Test;

import pages.ApproachPage;
import pages.CommonPage;
import pages.UptakePage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestApproachPage {

	WebDriver driver;
	UptakePage uptakePage;
	ApproachPage approachPage;
	CommonPage commonPage;
	
	String expectedUptakeTitle = "Uptake – Analytics for the Industrial Internet";
	String expectedApproachTitle = "Approach – Uptake";
	String expectedPlatformTitle = "Platform – Uptake";
	
	@Test(priority=0)
	public void approachPageTitleTest() {
		approachPage = new ApproachPage(driver);
		Assert.assertEquals(approachPage.getApproachPageTitle(), expectedApproachTitle);
	}

	@Test(priority=1)
	public void approachPageLinkTest() {
				
		Assert.assertTrue(commonPage.checkLinkTextExists("Approach"));
		Assert.assertTrue(commonPage.checkLinkTextExists("Platform"));
		Assert.assertTrue(commonPage.checkLinkTextExists("Solutions"));
		Assert.assertTrue(commonPage.checkLinkTextExists("People"));
		Assert.assertTrue(commonPage.checkLinkTextExists("Join Us"));
		Assert.assertTrue(commonPage.checkLinkTextExists("Contact Us"));
		Assert.assertTrue(commonPage.checkLinkTextExists("Blog"));
	}

	@Test(priority=2)
	public void approachPageNavigationTest() {
		
		commonPage.clickLinkByText("Approach");
		Assert.assertEquals(this.approachPage.getApproachPageTitle(),this.expectedApproachTitle);
		
		commonPage.clickLinkByText("Platform");
		Assert.assertEquals(this.approachPage.getApproachPageTitle(),this.expectedPlatformTitle);
		
		commonPage.clickUptakeLogo();
		Assert.assertEquals(this.approachPage.getApproachPageTitle(),this.expectedUptakeTitle);
	}
	
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://www.uptake.com/approach/");
		approachPage = new ApproachPage(driver);
		commonPage = new CommonPage(driver);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
