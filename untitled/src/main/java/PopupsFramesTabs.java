import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupsFramesTabs {
    public static void main(String[] arg){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement alert = driver.findElement(By.id("alertbtn"));
        alert.click();

        System.out.println("test pass");
    }
}
