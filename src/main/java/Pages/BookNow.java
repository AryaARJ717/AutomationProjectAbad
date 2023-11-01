package Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookNow {
	WebDriver Driver;
	@FindBy(xpath="//*[@id=\"wrapper\"]/header/nav/div/div[1]/div/button")
	WebElement bookNow;
	
	@FindBy(id="livchat_close")
	WebElement cl;
	
	@FindBy(xpath="//*[@id=\"booking-engine-groups\"]")
	WebElement engine_groups;
	
	@FindBy(xpath="//*[@id=\"booking-engine-hotels\"]")
	WebElement engine_hotels;
	
	@FindBy(xpath="//*[@id=\"booking-form\"]/div[7]/div/input")
	WebElement booking_form_button;
	
	@FindBy(xpath="//*[@id=\"checkInWrapper\"]/div")
	WebElement from_date;
	
	@FindBy(xpath="//*[@id=\"checkOutWrapper\"]/div")
	WebElement to_date;
	
	@FindBy(xpath="//*[@id=\"left-calendar-container\"]/div/div[1]/div/div[1]/select")
	WebElement from_cur_month;
	
	@FindBy(xpath="//*[@id=\"left-calendar-container\"]/div/div[1]/div/div[2]/select")
	WebElement from_cur_year;
	
	@FindBy(xpath="//*[@id=\"left-calendar-container\"]/div/div[2]/div/button")
	WebElement left_arrow;
	
	@FindBy(xpath="//*[@id=\"left-calendar-container\"]/div/div[3]/p[1]/div")
	WebElement space;
	
	@FindBy(xpath="//*[@id=\"left-calendar-container\"]/div/div[1]/table/tbody/tr/td")
	List<WebElement> from_days;
	
	@FindBy(xpath="//*[@id=\"left-calendar-container1\"]/div/div[1]/div/div[1]/select")
	WebElement to_cur_month;
	
	@FindBy(xpath="//*[@id=\"left-calendar-container1\"]/div/div[1]/div/div[2]/select")
	WebElement to_cur_year;
	
	@FindBy(xpath="//*[@id=\"left-calendar-container1\"]/div/div[2]/table/tbody/tr/td")
	List<WebElement> to_days;
	
	
	
	@FindBy(xpath="//*[@id=\"roomContainer-1\"]/div[2]/div/div[1]/div/input[3]\r\n"
			+ "	")
	WebElement add_adult;
	
	@FindBy(xpath="//*[@id=\"roomContainer-1\"]/div[2]/div/div[2]/div/input[3]")
	WebElement add_child;
	
	@FindBy(xpath="//*[@id=\"child-age-1-1\"]")
	WebElement age;
	
	@FindBy(xpath="//*[@id=\"workflow-step-0\"]/div/div[2]/div/div/div/div[1]/div/div[4]/div[2]/button/span")
	WebElement add_room;
	
	@FindBy(xpath="//*[@id=\"roomContainer-2\"]/div[2]/div/span[2]/i[2]")
	WebElement add_room_close;
	
	@FindBy(xpath="//*[@id=\"workflow-step-0\"]/div/div[2]/div/div/div/div[1]/div/div[5]/div/div/div[3]/div/button")
	WebElement check_availability;
	
	@FindBy(xpath="//*[@id=\"workflow-step-0\"]/div/div[2]/div/div/div/div[2]/div[1]/div/div/div/div")
	WebElement response;
	
	
	public BookNow(WebDriver driver)
	{
		this.Driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void openkbooknow()
	{
		Driver.manage().window().maximize();
		 bookNow.click();
	}
	public void clickClose()
	{
		
		cl.click();
	}
	public void setupbooking()
	{
		
		WebElement grp=engine_groups;
		Select g=new Select(grp);
		g.selectByVisibleText("Wayanad");
		
		WebElement htl=engine_hotels;
		Select h=new Select(htl);
		h.selectByVisibleText("Abad Brookside Lakkidi, Wayanad");
	}
	public void clickbooknow()
	{
		booking_form_button.click();
	}
	public void setfromdate() 
	{
		
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		from_date.click();
		JavascriptExecutor js=(JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,200)", "");
//		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[6]/ul/li[2]/a")));
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		from_cur_month.click();
		WebElement from_crnt_mt=from_cur_month;
		Select m=new Select(from_crnt_mt);
		m.selectByVisibleText("December");
//		from_crnt_mt.sendKeys(Keys.RETURN);
		
		
		from_cur_year.click();
		WebElement from_crnt_yr=from_cur_year;
		Select y=new Select(from_crnt_yr);
		y.selectByValue("2023");
		from_crnt_yr.sendKeys(Keys.RETURN);
		
		
		
		
//		List<WebElement> alldates1 = driver.findElements(By.xpath("//*[@id="left-calendar-container"]/div/div[1]/table/tbody/tr/td"));
		for(WebElement dateelement:from_days)
		{
			String date=dateelement.getText();
			        
			if(date.equals("27"))
			{
				dateelement.click();
				break;
			}
		}
	}
	public void setToDate()
	{
		to_date.click();
		to_cur_month.click();
		WebElement to_crnt_mt=to_cur_month;
		Select m=new Select(to_crnt_mt);
		m.selectByVisibleText("January");
		
		to_cur_year.click();
		WebElement to_crnt_yr=to_cur_year;
		Select y=new Select(to_crnt_yr);
		y.selectByValue("2024");
		to_crnt_yr.sendKeys(Keys.RETURN);
		
		for(WebElement dateelement:to_days)
		{
			String date=dateelement.getText();
			        
			if(date.equals("1"))
			{
				dateelement.click();
				break;
			}
		}
	}
	public void remainingsetup() 
	{
		add_adult.click();
		add_child.click();
		age.click();
		Select ag=new Select(age);
		ag.selectByVisibleText("6");
		add_room.click();
		add_room_close.click();	
	}
	public void checkAvailability()
	{
		check_availability.click();
	}
	public void screenshot() throws IOException 
	{
				File src1=response.getScreenshotAs(OutputType.FILE);	
				FileHandler.copy(src1, new File("./screenshot//ResponseScreenshot1.png"));
	}
}
