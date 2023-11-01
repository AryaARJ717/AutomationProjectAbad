package Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.BookNow;

public class BookNowPage {
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
	public void clickBooknow() throws IOException
	{
		BookNow bn=new BookNow(driver);
		bn.openkbooknow();
		bn.clickClose();
		bn.setupbooking();
		bn.clickbooknow();
		bn.setfromdate();
		bn.setToDate();
		bn.remainingsetup();
		bn.checkAvailability();
		bn.screenshot();
	}
}
