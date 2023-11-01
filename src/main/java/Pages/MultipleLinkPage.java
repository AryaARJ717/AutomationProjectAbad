package Pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleLinkPage {
	WebDriver driver;
	@FindBy(tagName="a")
	List<WebElement> li;
	
	@FindBy(xpath="//*[@id=\"top-navbar-collapse\"]/li[2]/a")
	WebElement offersAndPackages;
	
	@FindBy(xpath="//*[@id=\"top-navbar-collapse\"]/li[3]/a")
	WebElement dining;
	
	@FindBy(xpath="//*[@id=\"top-navbar-collapse\"]/li[6]/ul/li[6]/a")
	WebElement destinations;
	

	@FindBy(xpath="//*[@id=\"top-navbar-collapse\"]/li[6]/ul/li[4]/a")
	WebElement aboutUs;
	
	@FindBy(xpath="//*[@id=\"top-navbar-collapse\"]/li[6]/ul/li[2]/a")
	WebElement ayurvedha;
	
	@FindBy(xpath="//*[@id=\"top-navbar-collapse\"]/li[6]/ul/li[5]/a")
	WebElement blogs;
	
	public MultipleLinkPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void linkvalidation() 
	{
		System.out.println("total no of links="+li.size());
		for(WebElement s:li)
		{
			String link=s.getAttribute("href");
			try {
				URL ob=new URL(link);
				 HttpURLConnection con=(HttpURLConnection)ob.openConnection();
				 con.connect();
				 if(con.getResponseCode()==200) 
				 {
					 System.out.println("valid-----"+link);
				 }
				 else if(con.getResponseCode()==404)
				 {
					 System.out.println("brocken-----"+link);
				 }
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	public void dining()
	{
		dining.click();
	}
	public void OffersAndpackages()
	{
		offersAndPackages.click();
	}
	public void aboutus()
	{
		aboutUs.click();
	}
	public void ayurvedha()
	{
		ayurvedha.click();
	}
	public void blogs()
	{
		blogs.click();
	}
	
}
