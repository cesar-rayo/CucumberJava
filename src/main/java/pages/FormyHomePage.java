package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormyHomePage {
    private String url = "https://formy-project.herokuapp.com/";
    private WebDriver driver;

    public FormyHomePage(WebDriver driver) {
        this.driver = driver;
        load();
    }

    public void load() {
        this.driver.get(url);
    }

    private void clickOnLink(String linkName) {
        By locator = By.cssSelector(String.format("a[href='%s'][class='btn btn-lg']", linkName));
        driver.findElement(locator).click();
    }

    public FormPage clickFormLink() {
        clickOnLink("/form");
        return new FormPage(driver);
    }

}
