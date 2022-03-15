import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.id("ui-id-1"));
		
		List<WebElement> desiredOption = dropdown.findElements(By.tagName("li"));
		
		for (int i = 0; i < desiredOption.size(); i++) {
			if (desiredOption.get(i).getText().equals("India")) {
				desiredOption.get(i).click();
				break;
			}
		}
	}
}
