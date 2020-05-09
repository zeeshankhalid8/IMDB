package Tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.Timestamp;

public class handleBrowser extends PageObjects.page {

    final String TAG = "    handleBrowser():      | ";
    java.util.Date date= new java.util.Date();

    @BeforeSuite
    public void readyBrowser() {
        System.out.println(new Timestamp(date.getTime()) + TAG + "readyBrowser()");
        getDriver();
    }

    @AfterSuite
    public void tearDown(){
        System.out.println(new Timestamp(date.getTime()) + TAG + "tearDown()");
        driver.close();
        driver.quit();
    }
}


