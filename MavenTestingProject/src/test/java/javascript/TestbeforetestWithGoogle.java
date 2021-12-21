package javascript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.SeleniumUtility;


public class TestbeforetestWithGoogle extends SeleniumUtility {
	
	WebDriver driver;
	@BeforeTest
	public void testopenbrowser() {
		driver = SetUp("Chrome", "https://www.google.com/");
	}

/*even the title is not matched and test detect it it is not as per actual title
 * still the test will be showed as pass in testNG hence we have another methods
 * which will make the test failed if the actual value fails to matched with expected value
 */
	@Test(priority =1)
	public void testgoogleLandingpage() {
		String expectedTitle = "Google";
		String ActualTitle = driver.getTitle();
	//	System.out.println(expectedTitle.equals(ActualTitle));
		Assert.assertEquals(ActualTitle, expectedTitle, "page title got changed");
		System.out.println("testing of google landing page is finished");	
	}
	
	@Test (priority =2)
	public void testtextSearch() {
		WebElement searchbar = driver.findElement(By.name("q"));
	    Assert.assertTrue(searchbar.isDisplayed());
	    Assert.assertTrue(searchbar.isEnabled());
	    
	    searchbar.sendKeys("Selenium",Keys.ENTER);
	    System.out.println(driver.getTitle());
	    System.out.println("textSearch is finished");
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("alert('Enter proper word');");
	    driver.switchTo().alert().accept();
		driver.close();
		driver.quit();
		
	}

}
