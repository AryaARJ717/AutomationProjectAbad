package Tests;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.BookNow;
import Pages.SignUpPage;

public class SignUpTest {
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
	public void signUp() throws AWTException
	{
		SignUpPage s=new SignUpPage(driver);
		BookNow bn=new BookNow(driver);
		bn.openkbooknow();
		bn.clickClose();
		bn.setupbooking();
		bn.clickbooknow();
		s.SignUp();
		s.setvalues("Govind","kumargovind678gk@gmail.com","8976047898","GHK$#789");
		s.register();
	}
}
