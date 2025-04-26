package heroku;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.heroku.FormAuthenticationPage;

import static utils.Browser.*;

public class FormAuthenticationTest {

    FormAuthenticationPage formAuthenticationPage;

    @BeforeMethod
    void setup() {
        openBrowser("chrome");
        formAuthenticationPage = new FormAuthenticationPage();
    }

    @Parameters({"browser"})
    @Test
    void tc01(String browser) {
        formAuthenticationPage
                .open()
                .login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(formAuthenticationPage
                .getWelcomeMessage()
                .contains("You logged into a secure area!"));
        Assert.assertEquals(getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }

    @AfterMethod
    void tearDown() {
        quit();
    }
}