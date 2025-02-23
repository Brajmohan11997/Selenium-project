import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class allTest {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        //System.setProperty("webdriver.chrome.driver", "/Users/payzapp-automation/Documents/Practice-Demo/MSchool/Java-Selenium/drivers/chromedriver"); // Update the path

        // Create a new instance of ChromeDriver (or any other driver)
        ChromeDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://www.flipkart.com/");

        // Mouse Hover
        WebElement login = driver.findElement(By.xpath("//span[text()='Login']"));

        // ACtion Class Object
        Actions act = new Actions(driver);
        act.moveToElement(login).perform();

        Thread.sleep(5000);

        // Close the browser
        driver.quit();

    }
}
