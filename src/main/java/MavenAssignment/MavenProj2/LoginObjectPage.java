package MavenAssignment.MavenProj2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginObjectPage {
	WebDriver driver;	
	public LoginObjectPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="UserFirstName")
	WebElement FirstName;	
	@FindBy(name="UserLastName")
	WebElement LastName;	
	@FindBy(name="UserEmail")	
	WebElement Email;	
	@FindBy(name="UserTitle")
	WebElement JobTitle;
	@FindBy(name="UserPhone")
	WebElement Phone;
	@FindBy(name="CompanyName")
	WebElement Company;
	@FindBy(name="CompanyEmployees")
	WebElement Employees;
	@FindBy(xpath=".//*[@class='checkbox-ui']")
	WebElement checkbox;
	@FindBy(name="start my free trial")
	WebElement Enroll;
	
	public WebElement Firstname() 
	{
		return FirstName;
	}
	
	public WebElement Lastname() 
	{
		return LastName;
	}
	
	public WebElement Email() 
	{
		return Email;
	}
	
	public WebElement JobTitle() 
	{
		return JobTitle;
	}
	
	public WebElement Phone() 
	{
		return Phone;
	}	
	
	public WebElement Company() 
	{
		return Company;
	}	
	
	public WebElement NoofEmployees() 
	{
		return Employees;
	}	
	
	public void employeedropdown(int NoofEmployees)
	{
		Select empdropdown = new Select(Employees);
		 empdropdown.selectByIndex(NoofEmployees);
	}
	public WebElement checkBox() 
	{
		return checkbox;
	}	
    
	public WebElement Enroll() 
	{
		return Enroll;
	}	
}
