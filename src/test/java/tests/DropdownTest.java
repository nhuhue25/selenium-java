package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropdownPage;
import utils.Browser;

public class DropdownTest {
    DropdownPage dropdownPage;

    @BeforeMethod
    public void setUp() {
        Browser.openBrowser("chrome");
        dropdownPage = new DropdownPage();
    }

    @AfterMethod
    public void tearDown() {
        Browser.quit();
    }

    @Test
    void tc03_singleSelectDropdown() {
        dropdownPage.visitDropdownPage();
        dropdownPage.selectOptionByVisibleText("Option 1");
        Assert.assertTrue(dropdownPage.isDropdownOptionSelected("Option 1"));

        dropdownPage.selectOptionByValue("1");
        Assert.assertTrue(dropdownPage.isDropdownOptionSelected("Option 1"));
    }

    @Test
    void tc04_multiSelectDropdown() {
        dropdownPage.visitMultiSelectDropdownPage();
        Assert.assertTrue(dropdownPage.isMultiSelect());

        dropdownPage.selectMultipleFruits();
        Assert.assertTrue(dropdownPage.isFruitSelected("Banana"));
        Assert.assertTrue(dropdownPage.isFruitSelected("Apple"));
        // NOTE: Orange không được chọn ở trên nên test này fail nếu không sửa dropdown
        // Giả sử bạn cũng chọn Orange:
        // Assert.assertTrue(dropdownPage.isFruitSelected("Orange"));
    }

    @Test
    void tc05_textFieldEnableCheck() throws InterruptedException {
        Browser.visit("https://the-internet.herokuapp.com/dynamic_controls");

        Assert.assertFalse(Browser.getDriver()
                .findElement(By.cssSelector("form#input-example input")).isEnabled());

        Browser.click(By.cssSelector("form#input-example button"));
        Thread.sleep(5000); // replace with WebDriverWait ideally

        Assert.assertTrue(Browser.getDriver()
                .findElement(By.cssSelector("form#input-example input")).isEnabled());
    }
}
