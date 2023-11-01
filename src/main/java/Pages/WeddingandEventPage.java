package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeddingandEventPage {
	WebDriver driver;
	@FindBy(xpath="/html/body/main/header/nav/div/div[3]/ul/li[6]/ul/li[1]/a")
	WebElement Wedding;
	
	public WeddingandEventPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void loadWedding()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Wedding.click();
	}
}
