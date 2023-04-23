import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

public class ArchiveSelectTime {

    // minute must be even, 2minute interval
    // error may arise, seconds sometimes in it, sometimes not
    public static void startTime(ChromeDriver driver6, int h, int m, String am_pm) {
        //
        String str_h = String.format("%02d", h);
        String str_m = String.format("%02d", m);
        String str_s = "00";
        String W_us_time = str_h + ":" + str_m + ":" + str_s + am_pm;
        System.out.println(W_us_time);
        try {
            // this is tonardo
            Select drop_down = new Select(driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[3]/div/div[2]/select")));
            drop_down.selectByVisibleText(W_us_time);
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error: Time Selection...");
        }
    }

    public void navigateToRadar(ChromeDriver driver6) {
        // Radar Button Click
        try {
            driver6.findElement(By.xpath("/html/body/div[1]/div/nav[2]/div/div[2]/div/div/ul[1]/li[5]/a")).click();
            Thread.sleep(1000);

            // Radar Button Click
            driver6.findElement(By.xpath("/html/body/div[1]/div/nav[2]/div/div[2]/div/div/ul[1]/li[5]/ul/li/ul/li[1]/ul/li[1]/a")).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Erorr: Navigating to Radar...");
        }
    }

    public void radarDownloadButton(ChromeDriver driver6) {
        // Radar Button Click
        try {
            Thread.sleep(3000);
            //Download Button Click
            driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[3]/div[1]/div[1]/div/div/a")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error: Radar Button...");
        }
    }

    public void radarDownloader(ChromeDriver driver6) {
        // Radar Button Click
        try {
            // Save As Button (Official Download)
            Thread.sleep(3000);
            driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[3]/div[1]/div[15]/div[2]/a")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error: Downloading Radar...");
        }
    }

    // primary function of the class
    public void SelectStartTime(ChromeDriver driver6) {
        // navigate to the radar page
        navigateToRadar(driver6);

        // Select the Starting Time
        startTime(driver6, 1, 2, "am");

        // default radar is US Continent
        // Radar Button Click
        radarDownloadButton(driver6);

        // Download Image File Button Click
        radarDownloader(driver6);
    }
}
