package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class feedbackPage {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"wrapper\"]/div/div[1]/div/div/ul/li[2]/a")
	WebElement feedback_button;
	
	@FindBy(xpath="//*[@id=\"textbox_1589731495756\"]")
	WebElement Name;
	
	@FindBy(xpath="//*[@id=\"textbox_1589731510981\"]")
	WebElement Email;
	
	@FindBy(xpath="//*[@id=\"textbox_1589731533694\"]")
	WebElement Phone;
	
	@FindBy(xpath="//*[@id=\"textarea1589731556094\"]")
	WebElement feedback;
	
	@FindBy(xpath="//*[@id=\"btn-4964-803395-3276496\"]")
	WebElement submit_button;
	
	public feedbackPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void feedback()
	{
		feedback_button.click();
	}
	public void formfill(String name,String mail,String pho,String feed)
	{
		Name.sendKeys(name);
		Email.sendKeys(mail);
		Phone.sendKeys(pho);
		feedback.sendKeys(feed);
	}
	public void submit()
	{
		submit_button.click();
	}
}
