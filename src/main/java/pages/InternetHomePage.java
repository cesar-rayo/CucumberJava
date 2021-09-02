package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InternetHomePage {
    private WebDriver driver;
    private String url="https://the-internet.herokuapp.com";
    private By dynamicLink = By.cssSelector("a[href='/dynamic_content']");
    private By largeLink = By.cssSelector("a[href='/large']");

    public InternetHomePage(WebDriver driver) {
        this.driver = driver;
        load();
    }

    public void load() {
        this.driver.get(url);
    }

    public DynamicPage clickDynamicLink() {
        WebElement link = this.driver.findElement(dynamicLink);
        link.click();
        return new DynamicPage(this.driver);
    }

    public LargePage clickLargePageLink() {
        WebElement link = this.driver.findElement(largeLink);
        link.click();
        return new LargePage(this.driver);
    }
}
