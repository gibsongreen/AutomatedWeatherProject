package test;

import WeatherPackage.FloridaDownload;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFloridaDownload {
    ChromeDriver driver;
    FloridaDownload testClient = new FloridaDownload();

    @Test
    void Setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        // click accept cookies
        driver.get("https://weather.us/");
        driver.manage().window().maximize();
        Thread.sleep(2000); // wait for popup
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

}
