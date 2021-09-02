package pages;

import org.openqa.selenium.WebDriver;

public class InternetHomePage {
    private WebDriver driver;
    private String url="https://the-internet.herokuapp.com/dynamic_content";

    public InternetHomePage(WebDriver driver) {
        this.driver = driver;
        load();
    }

    public void load() {
        this.driver.get(url);
    }
}
