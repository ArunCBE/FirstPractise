package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException  {
		prop = new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\lenovo\\eclipse-workspace\\MavenProj2\\src\\main\\java\\resources\\userdetails.properties");

		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		String BaseURL = prop.getProperty("URL");
		System.out.println(BaseURL);
		

		if(browserName.equals("chrome"))
		{			
			//****Initialize Chrome Driver****//
			System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.get(BaseURL);			
		}
		else if (browserName.equals("firefox"))
		{
			//firefox code
			driver= new FirefoxDriver();			
		}
		else if (browserName.equals("IE"))
		{
          //To Write IE code
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
}
