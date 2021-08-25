package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThanksPage {
    private WebDriver driver;
    private By confirmationAlert = By.cssSelector("div.alert.alert-success");
    public ThanksPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationMsg() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationAlert));
        return alert.getText();
    }
}
