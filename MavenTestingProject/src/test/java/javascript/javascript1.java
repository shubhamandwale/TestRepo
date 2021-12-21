package javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;

public class javascript1 extends SeleniumUtility{
	
	WebDriver driver;
	
	
  @Test
  public void f() {
	  
	  
	  

		// Launching the Site.
	   driver = SetUp("chrome", "https://www.browserstack.com/users/sign_in");
		// Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('user_email_login').value='rbc@xyz.com';");
		js.executeScript("document.getElementById('user_password').value='password';");
		// click using javascript
		js.executeScript("document.getElementById('user_submit').click();");
		// or
//				WebElement signUp=driver.findElement(By.id("user_submit"));
//				 //Perform Click on LOGIN button using JavascriptExecutor		
//				js.executeScript("arguments[0].click();", signUp);

		js.executeScript("alert('enter correct login credentials to continue');");
		driver.switchTo().alert().accept();
		driver.close();

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
}
