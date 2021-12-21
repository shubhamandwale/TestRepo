package javascript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Testorangehrm{
	
	@Test
	public void TestLogin() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("document.getElementById('txtUsername').value='Admin';");
		js.executeScript("document.getElementById('txtPassword').value='admin123';");
	//	js.executeScript("document.getElementById('btnLogin').click();");
		
		//we can add alert using the JavascriptExecutor;
		js.executeScript("alert('enter correct details');");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element = driver.findElement(By.id("txtUsername"));
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(element)).clear();
		
		driver.close();
	}


}
