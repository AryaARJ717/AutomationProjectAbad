package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"wrapper\"]/header/nav/div/div[1]/div/button")
	WebElement bookNow;
	
	@FindBy(xpath="/html/body/main/header/nav/div/div[1]/div/div/div/div/div/div/div[2]/form/div[7]/div/input")
	WebElement booking_form_button;
	
	@FindBy(xpath="//*[@id=\"booking-engine-groups\"]")
	WebElement engine_groups;
	
	@FindBy(xpath="//*[@id=\"booking-engine-hotels\"]")
	WebElement engine_hotels;
	
	@FindBy(id="livchat_close")
	WebElement cl;
	
	@FindBy(xpath="/html/body/section/header/div/div/nav/div[2]/div[4]/a[1]")
	WebElement Login_form;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div/form/div[1]/input")
	WebElement Email;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div/form/div[2]/input")
	WebElement Password;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div/form/button")
	WebElement Login;
	
	@FindBy(xpath="/html/body/section/header/div/div/nav/div[2]/div")
	WebElement Account;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void openlogin()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Login_form.click();
	}
	public void setvalues(String email,String password)
	{
		Email.clear();
		Email.sendKeys(email);
		Password.clear();
		Password.sendKeys(password);
	}
	public void loginclick()
	{
		Login.click();
	}
	public void loginvalidation()
	{
//		String currentURL = driver.getCurrentUrl();
//		System.out.println(currentURL);
//        String expectedURL = "https://bookings.abadhotels.com/?chainId=4964&propertyId=4981&checkIn=2023-10-29&checkOut=2023-10-30&adults=1&children=0&promocode=&_ga=2.77016405.1146715157.1698559438-939291237.1698559438&_gl=1*1loyuys*_ga*OTM5MjkxMjM3LjE2OTg1NTk0Mzg.*_ga_MBPQ9H2744*MTY5ODU1OTQzNy4xLjAuMTY5ODU1OTQzNy42MC4wLjA.*_ga_DMYPKC176S*MTY5ODU1OTQzOC4xLjAuMTY5ODU1OTQzOC42MC4wLjA.";
//        Assert.assertEquals(currentURL, expectedURL, "Login failed!");
//        System.out.println("Login success!");
		
		Assert.assertTrue(Account.isDisplayed(), "Login successful");
		System.out.println("Login success!");
	}
}
