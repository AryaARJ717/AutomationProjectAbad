package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.PayUsPage;

public class PayUsTest {
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
	public void windowhandle() throws IOException {
		PayUsPage pg=new PayUsPage(driver);

		pg.windowHandle();
		pg.formfill("Goving", "Kumar", "govind123@gmail.com", "+916785488488", "Abc", "xyz", "1", "pqr");
		pg.submit();
		pg.screenshot();
	}
}
