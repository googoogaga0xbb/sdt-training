/*Please note that by the time I'm completing this, the way we are doing implicit/explicit ways is deprecated. Eclipse allowed me to add @suppresswarnings...
 * I did search Google what to use instead, but hat little issue trying to implement.*/

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		//GLOBAL DECLARATIONS
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Explicit wait 
		WebDriverWait wait = new WebDriverWait(driver,10); 
		
		//Go to site
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		//Fill Form
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		
		//wait for the alert to come up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		WebElement userDropdown = driver.findElement(By.tagName("select"));
		Select dropdown = new Select(userDropdown); 
		dropdown.selectByValue("consult");
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		//Picking a static element that shouldn't change that much, the logo area
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("navbar-brand")));
		
		//Adding items to cart - The task said "add all the items in the page"
		//Here we are taking all items in the page by the title so we can have an idea of how many products there are in the page and the for the FOR
		List<WebElement> items = driver.findElements(By.cssSelector("h4.card-title"));
		for (int i = 0; i < items.size(); i++) {
			driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();
		}
		
		//Clicking checkout
		driver.findElement(By.xpath("//a[contains(text(), 'Checkout')]")).click();
		
	}
}
