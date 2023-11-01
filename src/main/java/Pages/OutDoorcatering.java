package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OutDoorcatering {
	WebDriver driver;
	
	
	By OutDoor=By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div/div/ul/li[2]/a");
	
	By Name=By.xpath("//*[@id=\"textbox_1592912395478\"]");
	By Email=By.xpath("//*[@id=\"textbox_1592912440182\"]");
	By Phone=By.xpath("//*[@id=\"textbox_1592912462339\"]");
	By Place=By.xpath("//*[@id=\"select_1592913205084\"]");
	By Date=By.xpath("/html/body/main/div/div[2]/div/div/div[1]/div[9]/div/form/fieldset/div[5]/div/div/input");
	By Category=By.xpath("//*[@id=\"select_1592912654548\"]");
	By NumOfPeople=By.xpath("//*[@id=\"textbox_1592912710340\"]");
	By Additional=By.xpath("//*[@id=\"textarea1592912803292\"]");
	By Button=By.xpath("//*[@id=\"btn-4964-803897-3283872\"]");
	
	By dateText=By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div");
	By arrow=By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span");
	
	public OutDoorcatering(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void outdoor()
	{
		driver.findElement(OutDoor).click();
	}
	public void formfill(String name,String mail,String pho,String add)
	{
		driver.findElement(Name).sendKeys(name);
		driver.findElement(Email).sendKeys(mail);
		driver.findElement(Phone).sendKeys(pho);
		
		WebElement place=driver.findElement(Place);
		Select y=new Select(place);
		y.selectByVisibleText("Kochi");
		
		driver.findElement(Date).click();
		while(true)
		{
			WebElement date=driver.findElement(dateText);
			String month1=date.getText();
			if(month1.equals("November 2023"))
			{
				System.out.println(month1);
				break;
			}
			else
			{
				driver.findElement(arrow).click();
				
			}
		} 
		List<WebElement> alldates1 = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
		for(WebElement dateelement:alldates1)
		{
			String date=dateelement.getText();
			        
			if(date.equals("17"))
			{
				dateelement.click();
				break;
			}
		}
		
		WebElement cat=driver.findElement(Category);
		Select c=new Select(cat);
		c.selectByVisibleText("Live Counters");
		
		driver.findElement(NumOfPeople).sendKeys("2");
		driver.findElement(Additional).sendKeys(add);
	}
	public void buttonClick()
	{
		driver.findElement(Button).click();
	}
	
}
