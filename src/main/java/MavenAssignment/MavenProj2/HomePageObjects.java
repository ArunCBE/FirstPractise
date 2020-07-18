package MavenAssignment.MavenProj2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	WebDriver driver;	
	public HomePageObjects(WebDriver driver) 
	{
		    this.driver =  driver;
		    PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="signup_link")
	WebElement FreeTrialButton;
	
	public WebElement FreeTrial() 
	{
		return FreeTrialButton;
	}


}
