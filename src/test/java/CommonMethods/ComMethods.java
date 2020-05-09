package CommonMethods;

import PageObjects.page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class ComMethods extends page {
    private final String TAG = "         ComMethods():    | ";

    private java.util.Date date= new java.util.Date();

    public boolean click(By element) {
        System.out.println(new Timestamp(date.getTime()) + TAG + "click()");
        if (!driver.findElement(element).isDisplayed())
            driver.manage().timeouts().implicitlyWait(25000, TimeUnit.SECONDS);
        driver.findElement(element).click();
        return true;
    }

    public void wait(By element){
        System.out.println(new Timestamp(date.getTime()) + TAG + "wait()");
        if (!driver.findElement(element).isDisplayed()){
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }
    }

    public void sendKeys(By element, String txt){
        System.out.println(new Timestamp(date.getTime()) + TAG + "sendKeys()");
        driver.findElement(element).sendKeys(txt);
    }
}
