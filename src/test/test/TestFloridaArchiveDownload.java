package test;

import WeatherPackage.FloridaArchiveDownload;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFloridaArchiveDownload {
    ChromeDriver driver;
    FloridaArchiveDownload testClient = new FloridaArchiveDownload();

    @Test
    void Setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        // click accept cookies
        driver.get("https://weather.us/");
        driver.manage().window().maximize();
        Thread.sleep(1000); // wait for popup
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[1]/button")).click();
    }

    @AfterTest
    void Close(){
        driver.close();
    }

    @Test
    void TestNavigateToRadar(){
        testClient.navigateToRadar(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://weather.us/radar-us");

    }

    @Test
    void TestYearDropDown(){
        testClient.yearDropDown(driver, 2022);
        Select drop_down = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[1]/div/div/select")));
        WebElement option = drop_down.getFirstSelectedOption();
        Assert.assertEquals(option.getText(), "2022");
    }

    @Test
    void TestStateSelection(){
        testClient.stateSelection(driver, "Florida");
        Select drop_down = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[1]/div/div/div[2]/div[1]/div/div/div/select")));
        WebElement option = drop_down.getFirstSelectedOption();
        Assert.assertEquals(option.getText(), "Florida");
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
