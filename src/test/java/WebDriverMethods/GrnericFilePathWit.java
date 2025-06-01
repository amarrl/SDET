package WebDriverMethods;
 
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
 
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
 
public class GrnericFilePathWit {
 
    public static void main(String[] args) throws Exception {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
        String targetUrl = "https://mmpdev.trackier.com/v2/register";
        driver.get(targetUrl);
        String access = "O4WOFP67U4XHEYOR5AYDPITGTX3M6UKR";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        
        String filePath = System.getProperty("user.home") + File.separator + "track.mp3";
 
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 
            if (driver.findElements(By.xpath("//iframe[@title='reCAPTCHA']")).size() >= 1) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@title='reCAPTCHA']")));
                WebElement reCap = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
                driver.switchTo().frame(reCap);
                driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
                Thread.sleep(2000);
                int size = driver.findElements(By.xpath("//div[text()='You are verified']")).size();
                if (size == 0) {
                    driver.switchTo().parentFrame();
                    try {
                        wait.until(ExpectedConditions.elementToBeClickable(
                                By.xpath("//iframe[@title=\"recaptcha challenge expires in two minutes\"]")));
                    } catch (TimeoutException e) {
                        // ignore
                    }
                    WebElement reCapChalle = driver
                            .findElement(By.xpath("//iframe[@title=\"recaptcha challenge expires in two minutes\"]"));
                    driver.switchTo().frame(reCapChalle);
                    if (driver.findElements(By.xpath(
                            "//button[@title=\"Get an audio challenge\" and @style=\"display: none;\"]/../..//div[@class=\"button-holder audio-button-holder\"]"))
                            .size() <= 0) {
                        driver.findElement(By.xpath("//div[@class=\"button-holder audio-button-holder\"]")).click();
                    }
                    String href = driver.findElement(By.xpath("//div[@class=\"rc-audiochallenge-control\"]//audio"))
                            .getDomAttribute("src");
 
                    // Use the dynamic filePath here
                    String path = fileDownload(href, filePath);
                    String ml = getCaptcha(path, access);
                    if (ml.length() < 1) {
                        driver.findElement(By.xpath("//div[@class=\"button-holder reload-button-holder\"]")).click();
                        href = driver.findElement(By.xpath("//div[@class=\"rc-audiochallenge-control\"]//audio"))
                                .getDomAttribute("src");
                        path = fileDownload(href, filePath);
                        ml = getCaptcha(path, access);
                    }
                    driver.findElement(By.xpath("//input[@id=\"audio-response\"]")).click();
                    driver.findElement(By.xpath("//input[@id=\"audio-response\"]")).sendKeys(ml);
                    driver.findElement(By.xpath("//div[@class=\"verify-button-holder\"]")).click();
                    driver.switchTo().parentFrame();
                } else {
                    driver.switchTo().parentFrame();
                }
            }
 
            Thread.sleep(5000);
            // driver.quit();
 
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
 
    public static String fileDownload(String fileUrl, String destinationPath) {
        try {
            URL url = new URL(fileUrl);
            InputStream inputStream = url.openStream();
 
            Path destination = Paths.get(destinationPath);
            Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File downloaded to: " + destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to download the file." + e);
        }
        return destinationPath;
    }
 
    static String getCaptcha(String mp3InputFile, String accessToken) throws ParseException, IOException {
        String apiUrl = "https://api.wit.ai/speech";
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(apiUrl);
 
        httpPost.setHeader("Authorization", "Bearer " + accessToken);
 
        File audioFile = new File(mp3InputFile);
        FileEntity fileEntity = new FileEntity(audioFile, ContentType.create("audio/mpeg"));
 
        httpPost.setEntity(fileEntity);
 
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();
 
        if (responseEntity != null) {
            String responseString = EntityUtils.toString(responseEntity); 
            EntityUtils.consume(responseEntity);
            System.out.println("Wit.ai response: " + responseString);
            String finalValue = responseString.substring(responseString.lastIndexOf("text\": \"") + 8,
                    (responseString.lastIndexOf("\"traits\":") - 5));
            return finalValue;
        } else {
            throw new RuntimeException("Failed to get response from the API");
        }
    }
}

 