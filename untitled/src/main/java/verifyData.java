import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class verifyData {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();

        // Test 1
        driver.get("https://books.toscrape.com/");

        String expectedTitle = "All products | Books to Scrape - Sandbox"; // Corrected expected title
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test Case 1 Passed: Page title is correct.");
        } else {
            System.out.println("Test Case 1 Failed: Expected title: '" + expectedTitle + "', but got '" + actualTitle + "'");
        }

// Test 2
        driver.get("https://books.toscrape.com/");
        WebElement nonfictionLink = driver.findElement(By.linkText("Nonfiction"));;
        nonfictionLink.click();

        String expectUrl = "https://books.toscrape.com/catalogue/category/books/nonfiction_13/index.html";
        // Verify that the Nonfiction results page is displayed (URL contains "non-fiction")
        String currentUrl = driver.getCurrentUrl().toLowerCase();
        if (expectUrl.equals(currentUrl)) {
            System.out.println("Test Case 2 Passed: Nonfiction link works.");
        } else {
            System.out.println("Test Case 2 Failed: Not on the Nonfiction page. URL: " + currentUrl);
        }
        driver.quit();

    }
}
