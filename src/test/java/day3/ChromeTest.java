package day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChromeTest {
    @Test
    void openInDefaultMode() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
    }

    @Test
    void openWithBetaChromeVersion(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("136");
        WebDriver driver = new ChromeDriver (chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals (driver.getTitle(),"Selenium");
        driver.quit();
    }
}