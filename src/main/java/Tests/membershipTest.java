package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.MembershipPage;
import Pages.MultipleLinkPage;
import Pages.careerPage;
import Pages.feedbackPage;

public class membershipTest {
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
	public void load() throws IOException
	{
		
		MembershipPage fp=new MembershipPage(driver);
		fp.membership();
		fp.formfill("Govind", "dovind123@gmail.com", "8746564588", "good");
		fp.submit();
	}
	@Test(priority=2)
	public void linkValidation()
	{
		MultipleLinkPage m=new MultipleLinkPage(driver);
		
		m.linkvalidation();
	}
}
