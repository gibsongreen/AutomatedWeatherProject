package WeatherPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class USDownload {

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
    public void Cont_US_Downloader_Img(ChromeDriver driver6) {
        // navigate to the radar page
        navigateToRadar(driver6);

        // default radar is US Continent
        // Radar Button Click
        radarDownloadButton(driver6);

        // Download Image File Button Click
       radarDownloader(driver6);
    }
}
