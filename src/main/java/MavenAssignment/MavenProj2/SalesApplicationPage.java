package MavenAssignment.MavenProj2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SalesApplicationPage {
	WebDriver driver;	
	public SalesApplicationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By popup=By.xpath("//button[text()='Close this window']");
	
	@FindBy(xpath="//title[text()='Home | Salesforce']")
	WebElement Title;
	
	public WebElement getPopUp()
	{
		return driver.findElement(popup);
	}
	
	public int getPopUpSize()
	{
		return driver.findElements(popup).size();
	}
	
	public WebElement Title() 
	{
		return Title;
	}	
    
}