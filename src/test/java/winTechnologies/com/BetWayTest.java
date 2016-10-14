package winTechnologies.com;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BetWayTest {

    public static WebDriver driver;
    @Before
    public void startBrowser() {
        //invoking the driver object
        driver = new FirefoxDriver();
    }

    @After
    public void stopBrowser() {
        //Killing the driver object
        driver.quit();
    }

    @Test
    public void captureListOfHeadLines() throws Exception {
        //Launching news.google.com website
        driver.get("http://news.google.com/");
        //Maximize the browser window
        driver.manage().window().maximize();
        //Wait for Page to load
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //Capture the headlines and Printing them in the same order
        List<WebElement> headlines=driver.findElements(By.xpath("//table[@class='esc-layout-table']//h2//span[@class='titletext']"));
        try {
            Assert.assertNotNull(headlines);
            System.out.println("List of " + headlines.size() + " HeadLines:");
            for (WebElement newsHeadline : headlines) {
                System.out.println("HeadLine: " + newsHeadline.getText());
            }
        }catch (Exception e)
        {
            System.out.println("No Headlines found on the Page");
        }
    }
    @Test
    public void captureListOfGames() throws Exception {
        //Launching sports.betway.com website
        driver.get("https://sports.betway.com/");
        //Maximize the browser window
        driver.manage().window().maximize();
        //Wait for Page to load
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.linkText("Live Streaming")).click();
        //Capture the list of elements in Live streaming Section and printing them in same order
        List<WebElement> gameList = driver.findElements(By.xpath("//div[@id='bettinghomenews']/table/tbody/tr//a[contains(@class,'event_name')]"));
       try {
           Assert.assertNotNull(gameList);
           System.out.println("List of " + gameList.size() + " Games:");
           for (WebElement game : gameList) {
               System.out.println("Game Name: " + game.getText());
           }
       }catch (Exception e)
       {
           System.out.println("No games found in Live streaming");
       }
    }
}
