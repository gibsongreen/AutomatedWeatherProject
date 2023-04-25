package test;

import WeatherPackage.LeeDownload;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestLeeDownload {
    ChromeDriver driver;
    LeeDownload testClient = new LeeDownload();

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
    void TestNavigateToRadar(){
        testClient.navigateToRadar(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://weather.us/radar-us");
    }
    @Test
    void TestGpsSelector(){
        testClient.gpsSelector(driver);
    }
    @Test
    void TestRadarButton(){
        testClient.radarDownloadButton(driver);
    }
    @Test
    void TestRadarDownloader(){
        testClient.radarDownloader(driver);
    }
}