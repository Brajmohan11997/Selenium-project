import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class checkBox {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();

        // Test 3 checkBox
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

         List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));

        //Select multiple checkboxes
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) { // Check if not already selected
                checkbox.click();
                System.out.println("Checkbox selected.");
            } else {
                System.out.println("Checkbox already selected.");
            }
        }

        // Verify if each checkbox is selected and print the state
        for (int i = 0; i < checkboxes.size(); i++) {
            WebElement checkbox = checkboxes.get(i);
            boolean isSelected = checkbox.isSelected();
            System.out.println("Checkbox " + (i + 1) + " selected: " + isSelected);
        }

        // Ensure unchecked checkboxes are selected (if needed)
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
                System.out.println("Ensured checkbox is selected.");
            }
        }

        // Test 4 RadioButton
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type=\"radio\"]"));

        // Select a specific radio button (using value)
        String valueToSelect = "radio1";
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getAttribute("value").equals(valueToSelect)) {
                radioButton.click();
                System.out.println("Radio button with value '" + valueToSelect + "' selected.");
                break; // Exit the loop once the button is selected
            }
        }

        // Verify if the selected radio button is active (selected)
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getAttribute("value").equals(valueToSelect)) {
                boolean isSelected = radioButton.isSelected();
                System.out.println("Radio button with value '" + valueToSelect + "' is selected: " + isSelected);
                break;
            }
        }

        // Print all available radio button options along with their selection state
        System.out.println("Available radio button options and their states:");
        for (WebElement radioButton : radioButtons) {
            String value = radioButton.getAttribute("value");
            boolean isSelected = radioButton.isSelected();
            System.out.println("Value: " + value + ", Selected: " + isSelected);
        }
       Thread.sleep(3000);

        driver.quit();
    }
}
