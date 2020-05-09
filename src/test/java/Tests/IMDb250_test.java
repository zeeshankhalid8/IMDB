package Tests;

import PageObjects.IMDb250_page;
import org.testng.annotations.Test;

import java.sql.Timestamp;

public class IMDb250_test extends handleBrowser {

    private final String TAG = "    IMDb250_test():     | ";

    private java.util.Date date= new java.util.Date();
    private IMDb250_page pageObject = new IMDb250_page();

    @Test (priority = 0, description = "Function to check if the page is loaded and title is correct")
    public void CheckPageEssentials() {
        System.out.println(new Timestamp(date.getTime()) + TAG + "CheckPageEssentials()");
        pageObject.isDisplayed();
        pageObject.verifyTitle();
    }

    @Test (priority = 1,  description = "Function to check headings and body text")
    public void checkChartHeadingsAndBody() {
        System.out.println(new Timestamp(date.getTime()) + TAG + "checkChartHeadingsAndBody()");
        pageObject.verifyIMDbChartsHeading();
        pageObject.verifyTopRatedMoviesHeading();
        pageObject.verifyTopRatedMoviesHeadingBody();
        pageObject.verifyShowing250TitlesText();
    }

    @Test (priority = 2,  description = "Function to sort IMDb 250 movies chart")
    public void sortIMDb250Movies() {
        System.out.println(new Timestamp(date.getTime()) + TAG + "sortIMDb250Movies()");
        pageObject.sortMovies();
    }

    @Test (priority = 3,  description = "Function to share Top 250 movies")
    public void shareOnTwitter() throws InterruptedException {
        System.out.println(new Timestamp(date.getTime()) + TAG + "shareOnTwitter()");
        pageObject.clickShareButton();
        pageObject.clickTwitterOptionButton();
        pageObject.sharingOnTwitter();
    }
}
