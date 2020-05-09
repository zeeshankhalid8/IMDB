package PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class page {

    final String TAG = "      page():             | ";
    java.util.Date date= new java.util.Date();

    public static WebDriver driver;

    public WebDriver setDriver(){
        System.out.println(new Timestamp(date.getTime()) + TAG + "setDriver()");
        if(driver == null)
        {
            WebDriverManager.chromedriver().version("81.0.4044.69").setup();
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            options.addArguments("--enable-automation");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public WebDriver getDriver() {
        System.out.println(new Timestamp(date.getTime()) + TAG + "getDriver()");
        WebDriver driver = setDriver();
        driver.get("http://www.imdb.com/chart/top?ref_=nv_mv_250_6.");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        return driver;
    }

}
