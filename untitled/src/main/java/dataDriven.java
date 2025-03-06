import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;

public class dataDriven {
    public static void main(String[] args) throws IOException {
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.instagram.com/accounts/login/?hl=en");

        // Assuming you have implemented getDataFromExcel method to get username and password from Excel
        String username = getDataFromExcel("login.xlsx", "username");
        String password = getDataFromExcel("login.xlsx", "password");

        // Correct XPath usage
        driver.findElement(By.xpath("//input[@aria-label='Phone number, username, or email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys(password);

        // Corrected login button selector (You may need to inspect the page for the exact class or alternative locators)
        driver.findElement(By.xpath("//button[@class=\" _acan _acap _acas _aj1- _ap30\"]")).click();
    }

    // Method to read data from Excel
    public static String getDataFromExcel(String filePath, String key) throws IOException {
        FileInputStream file = new FileInputStream("D:\\untitled\\src\\file\\login.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        String data = "";

        // Assuming data is stored in the first sheet and column A is the key and column B is the value
        int rowCount = workbook.getSheetAt(0).getPhysicalNumberOfRows();
        for (int i = 0; i < rowCount; i++) {
            String cellKey = workbook.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();

            if (cellKey.equals(key)) {
                data = workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
            }
            else {
                data = workbook.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
            }

        }

        workbook.close();
        file.close();

        return data;
    }
}
