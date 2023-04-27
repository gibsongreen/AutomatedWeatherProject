package test;

import WeatherPackage.IterateFloridaArchive;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestIterateFloridaArchive {
    ChromeDriver driver;
    IterateFloridaArchive testClient = new IterateFloridaArchive();

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
    }
    @Test
    void TestStartTime(){
        testClient.startTime(driver, 1, 2, "am");
    }
    @Test
    void TestStateSelection(){
        testClient.stateSelection(driver, "Florida");
    }
    @Test
    void TestRadarDownloadButton(){
        testClient.radarDownloadButton(driver);
    }

    @Test
    void TestRadarDownloader(){
        testClient.radarDownloader(driver);
    }
    @Test
    void TestClickNextMinute(){
        testClient.clickNextMinute(driver);
    }
}