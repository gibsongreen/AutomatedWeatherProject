import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FloridaDownload {

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

    public void stateSelection(ChromeDriver driver6, String state) {
        //
        try {
            // Map Selection Button Click
            driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[1]/div/div/div[1]/a[1]")).click();
            Thread.sleep(2000);
            // Select State from Drop Down
            Select drop_down = new Select(driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[1]/div/div/div[2]/div[1]/div/div/div/select")));
            drop_down.selectByVisibleText(state);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error: State Location Selection...");
        }
    }

    // primary function of the class
    public void State_Downloader_Img(ChromeDriver driver6, String state) {
        // navigate to the radar page
        navigateToRadar(driver6);

        // Enter the name of the State we want to Download From
        stateSelection(driver6, state);

        // default radar is US Continent
        // Radar Button Click
        radarDownloadButton(driver6);

        // Download Image File Button Click
        radarDownloader(driver6);
    }
}
