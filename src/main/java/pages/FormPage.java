package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class FormPage {
    private WebDriver driver;
    private By firstnameField = By.id("first-name");
    private By lastnameField = By.id("last-name");
    private By jobtitleField = By.id("job-title");
    private By yearsOfExperienceField = By.id("select-menu");
    private By datepickerField = By.id("datepicker");
    private By submitBtn = By.cssSelector(".btn.btn-lg.btn-primary");

    private Map<String, String> educationLevelMap = new HashMap<>(){{
        put("High School","1");
        put("College","2");
        put("Grad School","3");
    }};

    private Map<String, String> sex = new HashMap<>(){{
        put("Male","1");
        put("Female","2");
        put("Prefer not to say","3");
    }};

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    private void typeInElementLocated(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }

    public void typeFirstName(String firstname) {
        typeInElementLocated(firstnameField, firstname);
    }

    public void typeLastName(String lastname) {
        typeInElementLocated(lastnameField, lastname);
    }

    public void typeJobTitle(String jobtitle) {
        typeInElementLocated(jobtitleField, jobtitle);
    }

    public void selectEducationLevel(String level) {
        StringBuilder stringBuilder = new StringBuilder("radio-button");
        stringBuilder.append("-" + educationLevelMap.get(level));
    }

    public void selectSex(String option) {
        StringBuilder stringBuilder = new StringBuilder("checkbox");
        stringBuilder.append("-" + sex.get(option));
    }

    public Select getYearsOfExperienceField() {
        return new Select(driver.findElement(yearsOfExperienceField));
    }

    public void selectYearsByVisibleText(String option) {
        getYearsOfExperienceField().selectByVisibleText(option);
    }

    public void typeDate(String date) {
        driver.findElement(datepickerField).sendKeys(date);
        driver.findElement(datepickerField).sendKeys(Keys.ENTER);
    }

    public ThanksPage clickSubmit() {
        driver.findElement(submitBtn).click();
        return new ThanksPage(driver);
    }
}
