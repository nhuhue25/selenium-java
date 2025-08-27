package pages;

import org.openqa.selenium.By;
import utils.Browser;

public class CheckboxesPage {
    private final By checkbox1 = By.xpath("//form[@id='checkboxes']/input[1]");
    private final By checkbox2 = By.xpath("//form[@id='checkboxes']/input[2]");

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/checkboxes");
    }

    public void checkCheckbox1() {
        Browser.check(checkbox1);
    }

    public void uncheckCheckbox1() {
        Browser.uncheck(checkbox1);
    }

    public boolean isCheckbox1Selected() {
        return Browser.isSelected(checkbox1);
    }

    public void checkCheckbox2() {
        Browser.check(checkbox2);
    }

    public void uncheckCheckbox2() {
        Browser.uncheck(checkbox2);
    }

    public boolean isCheckbox2Selected() {
        return Browser.isSelected(checkbox2);
    }
}
