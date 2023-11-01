package Tests;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.BookNow;
import Pages.HomePage;
import Pages.MultipleLinkPage;



public class HomeTest {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void urlload()
	{
		driver.get("https://www.abadhotels.com/");
	}
	@Test(priority=1)
	public void TitleValidation()
	{
		String actualTitle=driver.getTitle();
		String expecteTitle="Abad Hotels | Premium Hotels in Kerala| Resorts in Kerala";
		
		System.out.println(actualTitle);
		System.out.println(expecteTitle);
		
		if(actualTitle.equals(expecteTitle)) 
		{
			
			System.out.println("Title Checked");
		}
		else 
		{
				System.out.println("Title Fail");
		}
	}
	@Test(priority=2)
	public void contentVerification()
	{
		String actualPageSourse=driver.getPageSource();
		if(actualPageSourse.contains("HOLIDAY PACKAGES BY ABAD")) 
		{
			System.out.println("pass1");
		}
		else {
			System.out.println("Fail1");
		}
		
		if(actualPageSourse.contains("ABAD HOTELS AND RESORTS")) 
		{
			System.out.println("pass2");
		}
		else {
			System.out.println("Fail2");
		}
		if(actualPageSourse.contains("EXPLORE KERALA, EXPERIENCE ABAD")) 
		{
			System.out.println("pass3");
		}
		else {
			System.out.println("Fail3");
		}
		if(actualPageSourse.contains("OUR HOTELS AND RESORTS")) 
		{
			System.out.println("pass4");
		}
		else {
			System.out.println("Fail4");
		}
		
	}
	@Test(priority=3)
	public void logo()
	{
		HomePage hp=new HomePage(driver);
		hp.logdisplay();
	}
	@Test(priority=5)
	public void linkcount()
	{

		MultipleLinkPage hm=new MultipleLinkPage(driver);
		hm.linkvalidation();
	}	
	@Test(priority=4)
	public void datePick()
	{
		HomePage h=new HomePage(driver);
		h.HomeBook();
		h.clickBook();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BookNow b=new BookNow(driver);
		b.remainingsetup();
		b.checkAvailability();
	}
}
