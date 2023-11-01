package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.OutDoorcatering;

public class OutdoorTest {
	WebDriver driver;
	@BeforeTest
	public void setup() 
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void urlload()
	{
		driver.get("https://www.abadhotels.com/weddings-events/meetings-events.html");
	}
	@Test(priority=1)
	public void clickoutdoor()
	{
		OutDoorcatering od=new OutDoorcatering(driver);
		od.outdoor();
		od.formfill("Govind","Goving23@gmail.com","+918756864888","Nothing");
		od.buttonClick();
	}
}
