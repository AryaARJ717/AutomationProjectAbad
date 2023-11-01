package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MembershipPage {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"top-navbar-collapse\"]/li[4]/a")
	WebElement membership_button;
	
	@FindBy(xpath="//*[@id=\"textbox_1591452081024\"]")
	WebElement Name;
	
	@FindBy(xpath="//*[@id=\"textbox_1591452112469\"]")
	WebElement Email;
	
	@FindBy(xpath="//*[@id=\"textbox_1591452142140\"]")
	WebElement Phone;
	
	@FindBy(xpath="//*[@id=\"textarea1591452174425\"]")
	WebElement query;
	
	@FindBy(xpath="//*[@id=\"btn-4964-803940-3280723\"]")
	WebElement submit_button;
	
	public MembershipPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void membership()
	{
		membership_button.click();
	}
	public void formfill(String name,String mail,String pho,String qry)
	{
		Name.sendKeys(name);
		Email.sendKeys(mail);
		Phone.sendKeys(pho);
		query.sendKeys(qry);
	}
	public void submit()
	{
		submit_button.click();
	}
}
