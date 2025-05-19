package WebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomExample {
    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.automationtesting.in/shadow-dom");

        // Locate the shadow host
        WebElement shadowHost = driver.findElement(By.id("content"));

        // Access the shadow root
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);

        // Find the <p> element inside the shadow DOM and get its text
        WebElement pElement = shadowRoot.findElement(By.cssSelector("p"));
        String text = pElement.getText();
        System.out.println("Text inside Shadow DOM: " + text);

        // Close the browser
        driver.quit();
    }
}

