import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Date;

public class FloridaArchiveDownload {

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

    public void selectDateCurrentMonth(ChromeDriver driver6,int year, int month, int day, Date date) {
        //
        String str_year = String.format("%02d", year);
        String str_month = String.format("%02d", month);
        String str_day = String.format("%02d", day);

        String W_us_date = str_month + "/" + str_day + "/" + str_year;
        System.out.println(W_us_date);

        try {
            Thread.sleep(3000);
            Select drop_down = new Select(driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[2]/div/div[1]/select")));
            drop_down.selectByVisibleText(W_us_date);
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error: Time Selection...");
        }
    }

    public void yearDropDown(ChromeDriver driver6, int year) {
        // Radar Button Click
        String str_year = Integer.toString(year);
        try {
            Select drop_down = new Select(driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[1]/div/div/select")));
            drop_down.selectByVisibleText(str_year);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error: Year Drop Down...");
        }
    }

    // primary function of the class
    public void Archvive_State_Downloader_Img(ChromeDriver driver6, String state, Date date) {
        // navigate to the radar page
        navigateToRadar(driver6);

        // select a date
        //selectDateCurrentMonth(driver6,2023,4,1,date);
        // select year
        yearDropDown(driver6, 2022);

        // Enter the name of the State we want to Download From
        stateSelection(driver6, state);

        // default radar is US Continent
        // Radar Button Click
        radarDownloadButton(driver6);

        // Download Image File Button Click
        radarDownloader(driver6);
    }
}
