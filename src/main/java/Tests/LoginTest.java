package Tests;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.BookNow;
import Pages.LoginPage;
import Pages.SignUpPage;

public class LoginTest {
	WebDriver driver;
	@BeforeTest
	public void setup() 
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void urlload()
	{
		driver.get("https://www.abadhotels.com/weddings-events/meetings-events.html");
	}
	
	@Test(priority=1)
	public void signUp() throws AWTException, IOException
	{
		LoginPage lg=new LoginPage(driver);
		BookNow bn=new BookNow(driver);
		bn.openkbooknow();
		bn.clickClose();
		bn.setupbooking();
		bn.clickbooknow();
		lg.openlogin();
		
		File f=new File("D:\\AbadLogin.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
				XSSFSheet sh=wb.getSheet("Sheet1");
				System.out.println(sh.getLastRowNum());
				
				
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			String email=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("email="+email);
			String password=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("password="+password);
			
			lg.setvalues(email, password);
			lg.loginclick();
		}
		lg.loginvalidation();
	}
}
