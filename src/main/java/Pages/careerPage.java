package Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class careerPage {
	WebDriver driver;
	@FindBy(xpath="/html/body/main/header/nav/div/div[3]/ul/li[6]/a/i")
	WebElement Hambr;
	
	@FindBy(xpath="/html/body/main/header/nav/div/div[3]/ul/li[6]/ul/li[3]/a")
	WebElement Contact;
	
	@FindBy(xpath="//*[@id=\"wrapper\"]/div/div[1]/div/div/ul/li[3]/a")
	WebElement Career;
	
	@FindBy(xpath="/html/body/main/div/div[2]/div/div/div[1]/div[2]/div/form/fieldset/div[1]/div/input")
	WebElement Name;
	
	@FindBy(xpath="/html/body/main/div/div[2]/div/div/div[1]/div[2]/div/form/fieldset/div[2]/div/input")
	WebElement Email;
	
	@FindBy(xpath="/html/body/main/div/div[2]/div/div/div[1]/div[2]/div/form/fieldset/div[3]/div/input")
	WebElement Phno;
	
	@FindBy(xpath="/html/body/main/div/div[2]/div/div/div[1]/div[2]/div/form/fieldset/div[4]/div/input")
	WebElement Appy_for;
	
	@FindBy(xpath="/html/body/main/div/div[2]/div/div/div[1]/div[2]/div/form/fieldset/div[5]/div[2]/input")
	WebElement Resume;
	
	@FindBy(xpath="/html/body/main/div/div[2]/div/div/div[1]/div[2]/div/form/fieldset/div[6]/div/textarea")
	WebElement Descrep;
	
	@FindBy(xpath="/html/body/main/div/div[2]/div/div/div[1]/div[2]/div/form/fieldset/div[8]/div/button")
	WebElement Submit;
	
	@FindBy(xpath="//*[@id=\"recaptcha-anchor\"]/div[1]")
	WebElement captcha;
	
	public careerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void mouseHover()
	{
	
		Actions act=new Actions(driver);
		act.moveToElement(Hambr).perform();

	}
	public void ContactUs()
	{
		
		
//		Ham.click();
		Contact.click();
//		Career.click();
	}
	public void careerclick() 
	{
		Career.click();
	}
	public void setvalues(String name,String mail,String phno,String apply,String descrep)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
//		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[6]/ul/li[2]/a")));
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		
		Name.sendKeys(name);
		Email.sendKeys(mail);
		Phno.sendKeys(phno);
		Appy_for.sendKeys(apply);
		Resume.sendKeys("D:\\resume_001.docx");
		Descrep.sendKeys(descrep);
	}
	public void formSubmit() 
	{
		Submit.click();

	}
	public void screenshot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("D://fullPage.png"));
	}
}
