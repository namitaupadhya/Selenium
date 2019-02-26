package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	By username = By.name("userName");
	By password = By.name("password");
	By loginBtn = By.name("login");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}


	public void login(String uname,String pwd) {
		
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
	}
	
}
