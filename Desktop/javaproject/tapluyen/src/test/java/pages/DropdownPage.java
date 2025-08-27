package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;

public class DropdownPage {
    private final By dropdown = By.id("dropdown");
    private final By bananaOption = By.xpath("//option[.='Banana']");
    private final By appleOption = By.xpath("//option[.='Apple']");
    private final By oraangeOption = By.xpath("//option[.='Orange']");
    private final By fruitsSelect = By.id("fruits");

    public void visitDropdownPage() {
        Browser.visit("https://the-internet.herokuapp.com/dropdown");
    }

    public void visitMultiSelectDropdownPage() {
        Browser.visit("https://output.jsbin.com/osebed/2");
    }

    public void selectOptionByVisibleText(String text) {
        Select select = new Select(Browser.getDriver().findElement(dropdown));
        select.selectByVisibleText(text);
    }

    public void selectOptionByValue(String value) {
        Select select = new Select(Browser.getDriver().findElement(dropdown));
        select.selectByValue(value);
    }

    public void selectMultipleFruits() {
        Select select = new Select(Browser.getDriver().findElement(fruitsSelect));
        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");
        select.selectByVisibleText("Grape");
    }

    public boolean isFruitSelected(String fruit) {
        return Browser.getDriver().findElement(By.xpath("//option[.='" + fruit + "']")).isSelected();
    }

    public boolean isDropdownOptionSelected(String optionText) {
        return Browser.getDriver().findElement(By.xpath("//option[.='" + optionText + "']")).isSelected();
    }

    public boolean isMultiSelect() {
        Select select = new Select(Browser.getDriver().findElement(fruitsSelect));
        return select.isMultiple();
    }
}
