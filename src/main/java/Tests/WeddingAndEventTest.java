package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.MultipleLinkPage;
import Pages.WeddingandEventPage;

public class WeddingAndEventTest {
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
		driver.get("https://www.abadhotels.com/weddings-events/meetings-events.html");
	}
	@Test(priority=1)
	public void TitleValidation()
	{

		String actualTitle=driver.getTitle();
		String expecteTitle="Meetings & Events | Abad Hotels";
		
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
		if(actualPageSourse.contains("Conduct Your Meetings With Us")) 
		{
			System.out.println("pass1");
		}
		else {
			System.out.println("Fail1");
		}
		
		if(actualPageSourse.contains("Events and social gatherings are important happenings in everyone's life. To serve you better to your requirement, Abad has multiple banquet halls across its many properties which can be utilized for your events. A great blend of modernity and elegance, these rooms are equipped with amenities that are necessary for the smooth functioning of any event. Whether it is a training program, corporate event, wedding, or product launches, our banquet halls serve you the best.")) {
			System.out.println("pass2");
		}
		else {
			System.out.println("Fail2");
		}
	
	}
	@Test(priority=3)
	public void linkcount()
	{

		MultipleLinkPage hm=new MultipleLinkPage(driver);
		hm.linkvalidation();
	}
}
