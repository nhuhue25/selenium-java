package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.CheckboxesPage;
import utils.Browser;

public class CheckboxesTest {
    CheckboxesPage checkboxesPage;

    @BeforeClass
    void setUp() {
        Browser.openBrowser("chrome"); // mở trình duyệt qua lớp Browser
        checkboxesPage = new CheckboxesPage();
    }

    @BeforeMethod
    void reloadPage() {
        checkboxesPage.open(); // mở lại trang trước mỗi test
    }

    @Test
    void theCheckboxesShouldBeSelected() {
        checkboxesPage.checkCheckbox1();
        Assert.assertTrue(checkboxesPage.isCheckbox1Selected());

        checkboxesPage.checkCheckbox2();
        Assert.assertTrue(checkboxesPage.isCheckbox2Selected());
    }

    @Test
    void theCheckboxesShouldBeDeSelected() {
        checkboxesPage.uncheckCheckbox1();
        Assert.assertFalse(checkboxesPage.isCheckbox1Selected());

        checkboxesPage.uncheckCheckbox2();
        Assert.assertFalse(checkboxesPage.isCheckbox2Selected());
    }

    @AfterClass
    void tearDown() {
        Browser.quit(); // đóng trình duyệt
    }
}
