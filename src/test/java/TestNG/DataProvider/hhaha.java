package TestNG.DataProvider;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class hhaha {
	

    WebDriver driver;
    WebDriverWait wait; 

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
        driver.get("https://app.fireflink.com/");
    }

    @Test(priority = 2, dataProvider = "Dp")
    public void login(String email, String password) {
        try {
            // Handle pop-up if present
            WebElement reject = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Reject All']")));
            if (reject.isDisplayed()) {
                reject.click();
            }

            // Enter login details
            WebElement emails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='emailId']")));
            emails.sendKeys(email);

            WebElement passwords = driver.findElement(By.xpath("//input[@name='password']"));
            passwords.sendKeys(password);

            WebElement signIn = driver.findElement(By.xpath("//button[text()='Sign in']"));
            signIn.click();

            // Wait for product to appear
            WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product_1']//img[@alt='fireFlinkPlatform']")));
            wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();

            // Handle window switching
            String parentWindow = driver.getWindowHandle();
            Set<String> windows = driver.getWindowHandles();

            for (String window : windows) { 
                driver.switchTo().window(window); 
                if (driver.getTitle().equalsIgnoreCase("FireFlink")) {
                    System.out.println("Switched to window: " + driver.getTitle());
                    System.out.println("Current URL: " + driver.getCurrentUrl());
                    break;
                } 
            }

            // Logout process
            WebElement profileIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[local-name()='path' and @fill='currentColor'])[2]")));
            profileIcon.click();

            WebElement signOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Sign out']")));
            signOut.click();

            wait.until(ExpectedConditions.visibilityOf(signIn));

            // Switch back to parent window if needed
           // driver.switchTo().window(parentWindow);
        } catch (Exception e) {
            System.out.println("Test failed due to: " + e.getMessage());
        }
    }

    @DataProvider(name = "Dp", indices = {0, 1})
    public Object[][] loginData() {
        return new Object[][]{
                {"amar.r@testyantra.com", "Password@123"},
                {"amar.r@fireflink.com", "Amar@1400"}
        };
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
