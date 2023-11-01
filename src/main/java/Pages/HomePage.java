package Pages;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath="/html/body/main/header/nav/div/div[2]/a/img")
	WebElement log;
	

	
	@FindBy(xpath="//*[@id=\"booking-engine-groups\"]")
	WebElement Location;
	
	@FindBy(xpath="//*[@id=\"booking-engine-hotels\"]")
	WebElement hotel;
	
	@FindBy(xpath="/html/body/main/div[1]/div[3]/div/div/form/div[1]/div/input")
	WebElement CheckIn;
	
	@FindBy(xpath="/html/body/main/div[1]/div[3]/div/div/form/div[2]/div/input")
	WebElement CheckOut;
	
	@FindBy(xpath="/html/body/main/div[1]/div[3]/div/div/form/div[7]/div/input")
	WebElement Book;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div")
	WebElement getMonth;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div/span[2]/font/font")
	WebElement getYear;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")
	WebElement arrow;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a")
	List<WebElement> date;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div")
	WebElement getOutMonth;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div/span[2]/font/font")
	WebElement getOutYear;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/a[2]")
	WebElement arrowOut;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a")
	List<WebElement> dateOut;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void logdisplay()
	{
		if(log.isDisplayed())
		{
			System.out.println("Logo displayed");
		}
		else
		{
			System.out.println("Logo not displayed");
		}
	}
	public void HomeBook()
	{
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		Select l=new Select(Location);
		l.selectByVisibleText("Wayanad");
		
		Select h=new Select(hotel);
		h.selectByVisibleText("Parisons Plantation Experiences by ABAD, Wayanad");
		
		CheckIn.click();
		while(true)
		{
			String month1=getMonth.getText();
//			String year1=getYear.getText();
			if(month1.equals("November 2023"))
			{
				System.out.println(month1+"");
				break;
			}
			else
			{
				arrow.click();
				
			}
		} 
		for(WebElement d:date)
		{
			String dt=d.getText();
			        
			if(dt.equals("17"))
			{
				d.click();
				break;
			}
		}
		
		CheckOut.click();
		while(true)
		{
			String month1=getOutMonth.getText();
//			String year1=getOutYear.getText();
			if(month1.equals("November 2023"))
			{
				System.out.println(month1+"");
				break;
			}
			else
			{
				arrowOut.click();
				
			}
		} 
		for(WebElement dO:dateOut)
		{
			String dtO=dO.getText();
			        
			if(dtO.equals("19"))
			{
				dO.click();
				break;
			}
		}
		
	}
	public void clickBook()
	{
		Book.click();
	}
	

}
