import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutoSuggestive {


	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //Go to Site
		
		driver.findElement(By.id("autosuggest")).sendKeys("IND");
		Thread.sleep(3000);
		
		List<WebElement> options = (List<WebElement>) driver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); 
		
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		
		
	}

}
//