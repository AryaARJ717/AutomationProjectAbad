package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.careerPage;

public class CareerTest {
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
		careerPage cp=new careerPage(driver);
		cp.mouseHover();
		cp.ContactUs();
		cp.careerclick() ;
		cp.setvalues("Govind","Govind123@gmail.com","+918754638988","abc","xyz");
		cp.formSubmit();
		cp.screenshot();
	}
}
