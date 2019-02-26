package browser;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Login {
	
	WebDriver driver;
	HomePage homepage;
	static ExtentReports extent;
	static ExtentTest logger;
  

	    @Test(dataProvider = "newTourData")
	    public void loginPage(String uname,String pwd) {
	    	try {
	    		homepage=new HomePage(driver);
	  	  	  homepage.login(uname,pwd);
	  	  	  logger.log(LogStatus.PASS,"Test case is passed");
	    	}
	  	  catch(Exception e) {
	  		logger.log(LogStatus.FAIL,"Test case is failed");
	  	  }
	    	finally {
	    		extent.endTest(logger);
	    		extent.flush();
	    	}
	    }
	    
  @BeforeMethod
  public void beforeMethod() {
	  driver = new ChromeDriver();
	  driver.get("http://www.newtours.demoaut.com/");
	  driver.manage().window().maximize();
	  extent = new ExtentReports("C:\\Users\\namita.koni\\Desktop\\SeleniumAdv\\reports\\FinalExtentReports.html",true);
	  extent.assignProject("testing");
	  
	  
	  extent.addSystemInfo("Host Name",  "Autonamtion");
	  extent.addSystemInfo("Envt", "Demo");
	  extent.addSystemInfo("Username", "John");
	  
	  extent.loadConfig(new File("C:\\Users\\namita.koni\\Desktop\\SeleniumAdv\\reports\\extent-config.xml"));
	 logger =  extent.startTest("Training", "report generation happening");
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }
  
   @BeforeTest
   public void beforeTest() {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\namita.koni\\Desktop\\SeleniumAdv\\driver\\chromedriver.exe");
   }
   @DataProvider
   public Object[][] newTourData(){
	   return new Object[][] {{"demo","demo"}};
   }

}
