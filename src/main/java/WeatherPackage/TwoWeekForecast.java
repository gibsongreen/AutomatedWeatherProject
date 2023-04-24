package WeatherPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class TwoWeekForecast {
    public void navigateToForecast(ChromeDriver driver6) {
        // Radar Button Click
        try {
            driver6.findElement(By.xpath("/html/body/div[1]/div/nav[2]/div/div[2]/div/div/ul[1]/li[2]/a")).click();
            Thread.sleep(1000);

            // 14 Day Forecast Button Click
            driver6.findElement(By.xpath("/html/body/div[1]/div/nav[2]/div/div[2]/div/div/ul[1]/li[2]/ul/li[1]/ul/li[1]/ul/li[3]/a")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Erorr: Navigating to Radar...");
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
            File des = new File("C:\\Users\\gibso\\OneDrive\\Pictures\\Cartier-Bresson\\screenshot3.png");
            FileHandler.copy(src, des);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Erorr: Screenshotting Forecast...");
        }
    }

    // primary function of the class
    public void ForecastScreenshotTwoWeek(ChromeDriver driver6) throws IOException, InterruptedException {
        // navigate to the radar page
        navigateToForecast(driver6);

        // Nagivate to Current Location
        ClickGPSLocator(driver6);

        // Screenshot
        ScreenshotForecast(driver6);
    }
}
