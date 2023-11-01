package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.MultipleLinkPage;
import Pages.careerPage;

public class multipleLinkTest {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void urlload()
	{
		driver.get("https://www.abadhotels.com/");
	}
	@Test(priority=1)
	public void DiningValidation()
	{
		MultipleLinkPage m=new MultipleLinkPage(driver);
		m.dining();
		m.linkvalidation();
	}
	@Test(priority=2)
	public void PackageValidation()
	{
		MultipleLinkPage m=new MultipleLinkPage(driver);
		m.OffersAndpackages();
		m.linkvalidation();
	}
	@Test(priority=3)
	public void aboutusValidation()
	{
		careerPage c=new careerPage(driver);
		c.mouseHover();
		MultipleLinkPage m=new MultipleLinkPage(driver);
		m.aboutus();
		m.linkvalidation();
	}
	@Test(priority=4)
	public void ayurvedhaValidation()
	{
		careerPage c=new careerPage(driver);
		c.mouseHover();
		MultipleLinkPage m=new MultipleLinkPage(driver);
		m.ayurvedha();
		m.linkvalidation();
	}
	@Test(priority=5)
	public void blogValidation()
	{
		careerPage c=new careerPage(driver);
		c.mouseHover();
		MultipleLinkPage m=new MultipleLinkPage(driver);
		m.blogs();
		m.linkvalidation();
	}
	
}
