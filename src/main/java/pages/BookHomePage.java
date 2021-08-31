package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookHomePage {
    private WebDriver driver;
    private String url = "https://cesar-rayo.github.io/automated-visual-testing/website/index.html";
    private By searchBar = By.id("searchBar");
    private By visibleBooks =
            By.xpath("//li[not(contains(@class, 'ui-screen-hidden'))]");
    private By hiddenBooks =
            By.xpath("//li[contains(@class, 'ui-screen-hidden')]");


    public BookHomePage(WebDriver driver) {
        this.driver = driver;
        load();
    }

    private void load() {
        this.driver.get(url);
    }

    public void clearSearch() {
        driver.findElement(searchBar).clear();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.numberOfElementsToBe(hiddenBooks, 0));
    }

    public void search(String title) {
        clearSearch();
        driver.findElement(searchBar).sendKeys(title);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(hiddenBooks));
    }

    public int countBooks() {
        List<WebElement> books = driver.findElements(visibleBooks);
        return books.size();
    }

    public List<WebElement> getBooks() {
        return driver.findElements(visibleBooks);
    }

    public boolean isBookVisible(String title) {
        List<WebElement> books = getBooks();
        for (WebElement book: books) {
            String bookTitle = book.findElement(By.tagName("h2")).getText();
            System.out.println(bookTitle);
            if (bookTitle.equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }
}
