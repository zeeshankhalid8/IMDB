package PageObjects;

import CommonMethods.ComMethods;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Set;

public class IMDb250_page extends page {

    private final String TAG = "      IMDb250():          | ";
    private java.util.Date date = new java.util.Date();
    private ComMethods callCommonMethod = new ComMethods();

    //Elements
    private By mainContainer250 = By.id("root");
    private By IMDbChartsHeading = By.xpath("//div[@class='article']//h3[contains(text(),'IMDb Charts')]");
    private By topRatedMoviesHeading = By.cssSelector("h1[class='header']");
    private By topRatedMoviesHeadingBody = By.cssSelector("div[class='byline']");
    private By showing250TitlesText = By.cssSelector("div[class='desc']");
    private By sortMovies = By.cssSelector("span[class*='global-sprite lister-sort-reverse']");
    private By shareButton = By.cssSelector("button[title='Share']");
    private By twitterOptionButton = By.cssSelector("span[class='share-widget-sprite share twitter']");
    private By fbUserNameField = By.id("email");
    private By fbPasswordField = By.id("pass");
    private By twitterUserNameField = By.cssSelector("input[id='username_or_email']");
    private By twitterPasswordField = By.cssSelector("input[id='password']");
    private By tweetField = By.id("status");
    private By twitterSubmitButton = By.cssSelector("input[class='button selected submit']");

    //Functions
    public void isDisplayed()
    {
        System.out.println(new Timestamp(date.getTime()) + TAG + "isDisplayed()");
        callCommonMethod.wait(mainContainer250);

    }

    public void verifyTitle() {
        System.out.println(new Timestamp(date.getTime()) + TAG + "verifyTitle()");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "IMDb Top 250 - IMDb", TAG + " Page title was not found");
    }

    public void verifyIMDbChartsHeading() {
        System.out.println(new Timestamp(date.getTime()) + TAG + "verifyIMDbChartsHeading()");
        String firstHeadingText = driver.findElement(IMDbChartsHeading).getText();
        Assert.assertEquals(firstHeadingText, "IMDb Charts", TAG + " First heading was not found. ");
    }

    public void verifyTopRatedMoviesHeading() {
        System.out.println(new Timestamp(date.getTime()) + TAG + "verifyTopRatedMoviesHeading()");
        String secondHeadingText = driver.findElement(topRatedMoviesHeading).getText();
        Assert.assertEquals(secondHeadingText, "Top Rated Movies", TAG + " Second heading was not found. ");
    }

    public void verifyTopRatedMoviesHeadingBody() {
        System.out.println(new Timestamp(date.getTime()) + TAG + "verifyTopRatedMoviesHeadingBody()");
        String headingBodyText = driver.findElement(topRatedMoviesHeadingBody).getText();
        Assert.assertEquals(headingBodyText, "Top 250 as rated by IMDb Users", TAG + " Heading body was not found. ");
    }

    public void verifyShowing250TitlesText() {
        System.out.println(new Timestamp(date.getTime()) + TAG + "verifyShowing250TitlesText()");
        String showing250Titles_Text = driver.findElement(showing250TitlesText).getText();
        Assert.assertEquals(showing250Titles_Text, "Showing 250 Titles", TAG + " Chart text was not found. ");
    }

    public void sortMovies() {
        System.out.println(new Timestamp(date.getTime()) + TAG + "sortMovies()");
        callCommonMethod.wait(sortMovies);
        Assert.assertTrue(callCommonMethod.click(sortMovies), TAG + " Movies were not sorted in Descending order. ");
        Assert.assertEquals(getCurrentSortingOrder(),"Descending order");
        Assert.assertTrue(callCommonMethod.click(sortMovies), TAG + " Movies were not sorted in Ascending order. ");
        Assert.assertEquals(getCurrentSortingOrder(),"Ascending order");
    }

    public void clickShareButton() {
        System.out.println(new Timestamp(date.getTime()) + TAG + "clickShareButton()");
        Assert.assertTrue(callCommonMethod.click(shareButton), TAG + " Share button was not clicked. ");
    }

    public void clickTwitterOptionButton() throws InterruptedException {
        System.out.println(new Timestamp(date.getTime()) + TAG + "clickTwitterOption()");
        Assert.assertTrue(callCommonMethod.click(twitterOptionButton), TAG + " Twitter option button was not clicked. ");
        Thread.sleep(3000);
    }

    public void sharingOnTwitter() {
        System.out.println(new Timestamp(date.getTime()) + TAG + "sharingOnTwitter()");
        Set<String> windows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();
        windows.remove(parentWindow);
        Iterator<String> it = windows.iterator();
        String childWindow = null; //This is for reference of child window
        while(it.hasNext()){
            childWindow = (String) it.next();
            driver.switchTo().window(childWindow);
            Assert.assertTrue(callCommonMethod.click(tweetField), TAG + " Tweet field was not clicked. ");
            callCommonMethod.sendKeys(tweetField, " " + (System.currentTimeMillis()));
            Assert.assertTrue(callCommonMethod.click(twitterSubmitButton), TAG + " Twitter Submit button was not clicked. ");
            clickAndEnterUserName();
            clickAndEnterPassword();
            Assert.assertTrue(callCommonMethod.click(twitterSubmitButton), TAG + " Twitter Submit button was not clicked. ");
            callCommonMethod.wait(twitterSubmitButton);
            Assert.assertTrue(callCommonMethod.click(twitterSubmitButton), TAG + " Twitter Submit button was not clicked. ");
        }
        driver.switchTo().window(parentWindow); // switch back to parent window
    }

    public void clickAndEnterUserName(){
        System.out.println(new Timestamp(date.getTime()) + TAG + "clickAndEnterUserName()");
        driver.findElement(twitterUserNameField).sendKeys("+37253906620");
    }

    public void clickAndEnterPassword(){
        System.out.println(new Timestamp(date.getTime()) + TAG + "clickAndEnterPassword()");
        //Assert.assertTrue(callCommonMethod.click(twitterPasswordField), TAG + " Twitter Password field button was not clicked. ");
        driver.findElement(twitterPasswordField).sendKeys("Test1@");
    }

    public String getCurrentSortingOrder() {
        String order = driver.findElement(sortMovies).getAttribute("title");
        return order;
    }
}
