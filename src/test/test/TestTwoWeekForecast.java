package test;

import WeatherPackage.TwoWeekForecast;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestTwoWeekForecast {
    ChromeDriver driver;
    TwoWeekForecast testClient = new TwoWeekForecast();

    @BeforeTest
    void Setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://weather.us/");
        driver.manage().window().maximize();
        Thread.sleep(1000); // wait for popup
        // click accept cookies
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[1]/button")).click();
    }


    @AfterTest
    void Close() {
        driver.close();
    }

    @Test
    void TestNavigateToForecast(){
        testClient.navigateToForecast(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://weather.us/weather");
    }
    @Test
    void TestClickGPSLocator(){
        testClient.ClickGPSLocator(driver);
    }

    @Test
    void TestScreenshotForecast() throws IOException, InterruptedException {
        testClient.ScreenshotForecast(driver);
    }

}
