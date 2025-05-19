package WebDriverMethods;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetAndSetWebDriver {
	private WebDriver driver;

    @BeforeMethod 
    public void setUp() {
        // Get WebDriver instance
        driver = DriverManager.getDriver();

        // Optional: Set the WebDriver instance manually
        DriverManager.setDriver(driver);
    }

    @Test
    public void testGoogleTitle() {
        WebDriver driver = DriverManager.getDriver();
        
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        	
        // Verify the page title contains "Google"
        Assert.assertTrue(title.contains("Google"), "Title does not match");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}


