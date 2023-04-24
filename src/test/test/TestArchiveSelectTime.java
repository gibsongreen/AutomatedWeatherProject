package test;
import WeatherPackage.ArchiveSelectTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestArchiveSelectTime {
    String str_h;
    String str_m;
    String str_s;
    String W_us_time;
    ChromeDriver driver;
    ArchiveSelectTime testClient = new ArchiveSelectTime();

    @Test
    void Setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        str_h = String.format("%02d",1);
        str_m = String.format("%02d", 2);
        str_s = "00";
        W_us_time = str_h + ":" + str_m + ":" + str_s + "am";
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
    }

    @Test
    void TestSelectStartTime(){
        testClient.startTime(driver, 1, 2, "am");
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
