package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
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
	
	@FindBy(xpath="/html/body/section/header/div/div/nav/div[2]/div[4]/a[2]")
	WebElement signup_button;
	
	@FindBy(xpath="//*[@id=\"signUpForm\"]/div/form/div[1]/input")
	WebElement Name;
	
	@FindBy(xpath="//*[@id=\"signUpForm\"]/div/form/div[2]/input")
	WebElement Email;
	
	@FindBy(xpath="//*[@id=\"signUpForm\"]/div/form/div[3]/input")
	WebElement Phone;
	
	@FindBy(xpath="//*[@id=\"signUpForm\"]/div/form/div[4]/input")
	WebElement Password;
	
	@FindBy(xpath="//*[@id=\"signUpForm\"]/div/form/div[5]/input")
	WebElement Confirm;
	
	@FindBy(xpath="//*[@id=\"signUpForm\"]/div/form/button")
	WebElement Register;
	
	public SignUpPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void SignUp() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		signup_button.click();
	}
	public void setvalues(String name,String mail,String pho,String pass) throws AWTException
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Name.sendKeys(name);
		Email.sendKeys(mail);
		Phone.sendKeys(pho);
		Password.sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		Actions act=new Actions(driver);
//		act.keyDown(Password,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
//		act.keyDown(Password,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
//		act.moveToElement(Confirm).click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
////		act.build().perform();
//		act.perform();
		
		
		StringSelection stringSelection = new StringSelection(pass);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Confirm.click(); 
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void register()
	{
		Register.click();
	}

}
