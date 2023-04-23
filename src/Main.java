import org.openqa.selenium.edge.EdgeDriver;
import java.util.Date;
import org.openqa.selenium.chrome.ChromeOptions;
//package SeleniumBasicCommands;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.io.*;
import java.util.concurrent.TimeUnit;
import java.lang.Thread;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Date date = new Date();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gibso\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver6 = new ChromeDriver(options);
        try {
            driver6.get("https://weather.us/");
            driver6.manage().window().maximize();
            Thread.sleep(1000);
            // Accepting Cookies Handler
            driver6.switchTo().frame(1);
            driver6.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[1]/button")).click();
            Thread.sleep(1000);

            // 1.  State Test
            // FloridaDownload f_d = new FloridaDownload();
            //f_d.State_Downloader_Img(driver6,"Florida");

            // 2.  US Continent Test
            //USDownload us_d = new USDownload();
            //us_d.Cont_US_Downloader_Img(driver6);

            // 3.  Lee Test
            //LeeDownload lee_d = new LeeDownload();
            //lee_d.GPS_Downloader_Img(driver6);

            // 4.  Florida Archive Year Selection Download
            //FloridaArchiveDownload fl_a_d = new FloridaArchiveDownload();
            //fl_a_d.Archvive_State_Downloader_Img(driver6,"Florida", date);

            // 5.  Forecast Radar Screenshot
            //ForecastRadar fore_r = new ForecastRadar();
            //fore_r.ForecastScreenshotGPS(driver6);

            // 6.  Forecast 2 weeks
            //TwoWeekForecast two_week = new TwoWeekForecast();
            //two_week.ForecastScreenshotTwoWeek(driver6);

            // 7.  Archive Select by Time
            //ArchiveSelectTime select_t = new ArchiveSelectTime();
            //select_t.SelectStartTime(driver6);

            // 8. Iterate Over State Download Archive
            //IterateFloridaArchive florida_it = new IterateFloridaArchive();
            //florida_it.IterateDownloadState(driver6);

        } catch (InterruptedException e) {
            System.out.println("911! We have a problem...");
        } finally {
            driver6.close();
        }

    }

    public static void navigateToRadar(ChromeDriver driver6) {
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

    public static void clickNextMinute(ChromeDriver driver6) {
        // Radar Button Click
        try {
            // Next 2min Interval Button Click
            Thread.sleep(3000);
            driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[3]/div/div[2]/span[2]")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Erorr: 2min Interval Button...");
        }
    }
    public static void radarDownloadButton(ChromeDriver driver6) {
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

    public static void radarDownloader(ChromeDriver driver6) {
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

    public static void yearDropDown(ChromeDriver driver6, int year) {
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

    public static void stateSelection(ChromeDriver driver6, String state) {
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

    public static void gpsSelector(ChromeDriver driver6) {
        //
        try {
            // Map Selection Button Click
            driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[3]/div[1]/div[13]/div[8]/button[2]")).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error: GPS Location Selection...");
        }
    }

    public static void sdRadar(ChromeDriver driver6) {
        //
        try {
            // this is SD
            driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[3]/div[1]/div[13]/div[8]/button[6]")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error: Standard Radar Selection...");
        }
    }

    public static void hdRadar(ChromeDriver driver6) {
        //
        try {
            // this is HD
            driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[3]/div[1]/div[13]/div[11]/button[5]")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error: Standard Radar Selection...");
        }
    }

    // Doesn't Work
    public static void thunderstormRadar(ChromeDriver driver6) {
        //
        try {
            //this should be thunderstorm
            driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[5]/a[10]")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error: Thunderstorm Radar Selection...");
        }
    }

    public static void torandoRadar(ChromeDriver driver6) {
        //
        try {
            // Thunderstorm Radar Button Click

            // this is tonardo
            driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[3]/div[1]/div[13]/div[8]/button[7]")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error: Tornado Radar Selection...");
        }
    }
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

    public static void selectDateCurrentMonth(ChromeDriver driver6,int year, int month, int day, Date date) {
        //
        String str_year = String.format("%02d", year);
        String str_month = String.format("%02d", month);
        String str_day = String.format("%02d", day);

        String W_us_date = str_month + "/" + str_day + "/" + str_year;
        System.out.println(W_us_date);

        try {
            // this is tonardo
            Select drop_down = new Select(driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[2]/div/div[1]/select")));
            drop_down.selectByVisibleText(W_us_date);
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error: Time Selection...");
        }
    }


    // Does Work
    public static void dateDropDown(ChromeDriver driver6, int month, int day, Date date) {
        // Radar Button Click
        String str_month = Integer.toString(month);
        String str_day = Integer.toString(day);
        System.out.println(str_month + str_day);

        // display formatted date
        String sf1 = String.format("%tm %<te", date);
        String[] result = sf1.split(" ");
        // current month and date
        String mon = result[0];
        String d = result[1];
        System.out.printf("Current month : " + mon + ", day : " + d + "\n");

        int curr_mon = Integer.valueOf(mon);
        int curr_day = Integer.valueOf(d);

        int month_click_count = curr_mon - month;
        System.out.println("Count of month clicks: " + month_click_count);
        // if negative, then click the right button that number of times (abs)
        if (month_click_count < 0) {
            int temp = month_click_count * -1;
            // click the calender
            // navigate to the correct month
            // Calender Button Press
            driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[2]/div/div[1]/span[2]")).click();
            for (int i = 1; i <= temp; i++) {
                try {
                    Thread.sleep(2000);
                    // right button click
                    driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[2]/div/div[1]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[3]")).click();
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println("Error: Right Button Calender..." + "i = " + i);
                    ///html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[2]/div/div[1]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[1]
                }
            }
            // else (postive), click the left button that number of times (abs)

            // try {
            //   Select drop_down = new Select(driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[1]/div/div/select")));
            // drop_down.selectByVisibleText(str_year);
            //} catch (Exception e) {
            //  System.out.println("Error: Year Drop Down" + e);
            //}
        }
        else {
            // click the calender
            // navigate to the correct month
            try {
                // click the calender
                driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[2]/div/div[1]/span[2]")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Error: Clicking Calender, Left");
            }
            try {
                // month selection button
                driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[2]/div/div[1]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[2]")).click();
                Thread.sleep(4000);
                // Click Date
            } catch (Exception e) {
                System.out.println("Error: Left Button Calender...");
                ///html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[2]/div/div[1]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[1]
            }
            try {
                // July
                driver6.findElement(By.xpath("/html/body/div[1]/div/div[6]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/form/div[2]/div[1]/div[2]/div/div[1]/div/ul/li[1]/div/div[2]/table/tbody/tr/td/span[7]")).click();
                Thread.sleep(4000);
            } catch (Exception e) {
                System.out.println("Error: with July");
            }
        }
    }
}