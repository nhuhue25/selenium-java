package day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Brave {
    @Test
    void openBrowserWithDefaultMode(){
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

        // Khởi tạo WebDriver với Brave
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.selenium.dev/");
        System.out.println(driver.getTitle());

        driver.quit();
    }
}
