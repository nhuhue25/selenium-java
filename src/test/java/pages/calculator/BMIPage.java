package pages.calculator;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class BMIPage {
    /*
    fill form
    get result
    clear form
    select unitmetric
     */

    public void open(){
        visit("https://www.calculator.net/bmi-calculator.html");
    }

    public void selectUnitMetric() {
        click(By.cssSelector("#menuon a"));

    }
    public void clearForm(){
        click(By.xpath("//input[@value='Clear']"));
    }
    public void fillForm(String age,String gender, String height, String weight) {
        fill(By.id("cage"),age);

        if(gender.equalsIgnoreCase("male")){
            check(By.id("csex1"));

        }else {
            check(By.id("csex2"));
        }
        fill(By.id("cheightmeter"),height);
        fill(By.id("ckg"),weight);
        click(By.xpath("//input[@value='Calculate']"));
    }
    public String getResultText() {
        return getText(By.cssSelector(".bigtext"));
    }

}
