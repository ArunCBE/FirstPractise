package MavenAssignment.MavenProj2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;

import resources.Base;

public class SalesForceAppTest extends Base {
	public WebDriver driver;
	public ExtentReports extent;

@BeforeTest
	   public void Initializedriver() throws IOException
	   {
	       //****Initializing the driver****//
	       driver = initializeDriver();
		   System.out.println(driver.getTitle());	 
	   }

@Test(dataProvider="getData")
	  public void signUp(String Firstname, 
                         String Lastname,
                         String Email,
                         String JobTitle,
                         String Phone,
                         String Company) {		        
	        //*****Home Page Actions - Click the free trial button*****//
			HomePageObjects hp = new HomePageObjects(driver);
			hp.FreeTrial().click();
			
				
		 	//*****Maximize the window and wait*****//
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		    //*****Actions on Login Page*****//
			LoginObjectPage logpg = new LoginObjectPage(driver);
	    	logpg.Firstname().sendKeys(Firstname);
	    	logpg.Lastname().sendKeys(Lastname);
	    	logpg.Email().sendKeys(Email);
	    	logpg.JobTitle().sendKeys(JobTitle);
	    	logpg.Phone().sendKeys(Phone);
	    	logpg.Company().sendKeys(Company);
	    	logpg.NoofEmployees().click();
	    	logpg.employeedropdown(3);
	    	logpg.checkBox().click();
	    	logpg.Enroll().click();	    
	        System.out.println(driver.getTitle());
	       
	   }

@Test
       public void signinvalidation() {
	        //****Validation of successful navigation to Sales Force Application with Title of the page****//
	        SalesApplicationPage spg = new SalesApplicationPage(driver);
            if(spg.getPopUpSize()>0)
	        {
		     spg.getPopUp().click();
	        }
            System.out.println(driver.getTitle());
            Assert.assertTrue(driver.getTitle().equals("Home | Salesforrrce"));
       }


@AfterTest
       public void teardown()
           {
	        driver.close();
           }

    

@DataProvider
       public Object[][] getData()
            {
	        // Row stands for how many different data types test should run
	        //coloumn stands for how many values per each test
	
	        // Array size is 2
	        // 0,1
	        Object[][] data=new Object[1][6];
	        //0th row
	        data[0][0]="Arun Raja";
	        data[0][1]="A";
	        data[0][2]="arunraja.amirth@gmail.com";
	        data[0][3]="Test Lead";
	        data[0][4]="8971970444";
	        data[0][5]="Attra";
	        return data;
            }
}