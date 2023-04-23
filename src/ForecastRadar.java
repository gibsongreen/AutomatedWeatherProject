import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.util.Date;

public class ForecastRadar {
    public void navigateToForecast(ChromeDriver driver6) {
        try {
            driver6.findElement(By.xpath("/html/body/div[1]/div/nav[2]/div/div[2]/div/div/ul[1]/li[2]/a")).click();
            Thread.sleep(1000);

            // Forecast Radar Button Click
            driver6.findElement(By.xpath("/html/body/div[1]/div/nav[2]/div/div[2]/div/div/ul[1]/li[2]/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Erorr: Navigating to Radar...");
        }
    }

    public void SendLocationKey(ChromeDriver driver6, String location) {
        // Radar Button Click
        try {
            Thread.sleep(2000);
            WebElement sendLocation = driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div[1]/div/div/div[1]/div[1]/div[1]/form/div/div[1]/input"));
            Thread.sleep(2000);
            sendLocation.sendKeys("Bonita Springs");
            Thread.sleep(3000);

            // Radar Button Click
            driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div[1]/div/div/div[1]/div[1]/div[1]/form/div/span[2]")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Erorr: Selecting Location...");
        }
    }
    public void ClickGPSLocator(ChromeDriver driver6) {
        try {
            // GPS Forecast Button Click
            Thread.sleep(3000);
            driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div[1]/div/div/div[1]/div[1]/div[1]/div/div[1]/form/div/span[1]")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Erorr: Selecting Location...");
        }
    }
    public void ScreenshotForecast(ChromeDriver driver6) throws InterruptedException, IOException {
        try {
            Thread.sleep(2000);
            TakesScreenshot screenshot = (TakesScreenshot) driver6;
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            File des = new File("C:\\Users\\gibso\\OneDrive\\Pictures\\Cartier-Bresson\\screenshot2.png");
            FileHandler.copy(src, des);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Erorr: Screenshotting Forecast...");
        }

    }

    // primary function of the class
    public void ForecastScreenshotGPS(ChromeDriver driver6) throws IOException, InterruptedException {
        // navigate to the radar page
        navigateToForecast(driver6);

        // Nagivate to Current Location
        ClickGPSLocator(driver6);

        // Screenshot
        ScreenshotForecast(driver6);
    }
}
