package Pages;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayUsPage {
	WebDriver driver;
	@FindBy(xpath="/html/body/main/header/nav/div/div[3]/ul/li[5]/a")
	WebElement PayUs_button;
	
	@FindBy(id="paymentmaster-first_name")
	WebElement first_name;
	
	@FindBy(id="paymentmaster-last_name")
	WebElement last_name;
	
	@FindBy(id="paymentmaster-email")
	WebElement email;
	
	@FindBy(id="paymentmaster-phone")
	WebElement phone;
	
	@FindBy(id="paymentmaster-address")
	WebElement address;
	
	@FindBy(id="paymentmaster-city")
	WebElement city;
	
	@FindBy(id="paymentmaster-amount")
	WebElement amount;
	
	@FindBy(xpath="//*[@id=\"paymentmaster-field_127\"]")
	WebElement remark;
	
	@FindBy(xpath="//*[@id=\"subm\"]")
	WebElement submit;
	
	public PayUsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void windowHandle()
	{
		String parentWindow=driver.getWindowHandle();
		PayUs_button.click();
		Set<String> allwindowhandles = driver.getWindowHandles();
		for(String handle:allwindowhandles)
		{
			
//			System.out.println(handle);
			if(!handle.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(handle);
				String actualTitle=driver.getTitle();	
				String expecteTitle="Abad Hotels India Pvt Ltd";
				
				System.out.println(actualTitle);
				if(actualTitle.equals(expecteTitle)) 
				{
					
					System.out.println("Pass");
				}
				else 
				{
						System.out.println("Fail");
				}
			}
		}
	}
	public void formfill(String first,String last,String mail, String pho,String adrs,String cty,String amnt,String rmrk)
	{
		first_name.sendKeys(first);
		last_name.sendKeys(last);
		email.sendKeys(mail);
		phone.sendKeys(pho);
		address.sendKeys(adrs);
		city.sendKeys(cty);
		amount.sendKeys(amnt);
		remark.sendKeys(rmrk);
	}
	public void submit()
	{
		submit.click();
	}
	public void screenshot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("D://PayUsfullPage.png"));
	}
}
