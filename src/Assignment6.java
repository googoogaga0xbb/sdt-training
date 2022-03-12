import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Count Checkboxes or labels in the area
		System.out.println("The amount of checkboxes in the area is " + driver.findElements(By.xpath("//div[@id='checkbox-example']//label")).size());
		
		//Random number generator based on the amount of labels in the checkbox area
		//This number will be used as index 
		Random rand = new Random();
		int randValue = rand.nextInt(driver.findElements(By.xpath("//div[@id='checkbox-example']//label")).size());

		//Based on index, select text and checkbox
		String optValue = driver.findElements(By.xpath("//div[@id='checkbox-example']//label")).get(randValue).getText();
		System.out.println("The random selected label was: " + optValue);
		driver.findElements(By.xpath("//div[@id='checkbox-example']//input[@type='checkbox']")).get(randValue).click();
		
		//Go to Static dropdown and select the correct option based on previous value
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(optValue);
		
		//Entering name and getting the text from the alert.
		driver.findElement(By.id("name")).sendKeys(optValue);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		String alert = driver.switchTo().alert().getText();
		if (alert.contains(optValue))
			System.out.println("The " + optValue + " label was found in the alert");
		else
			System.out.println("The " + optValue + " label was not found in the alert");
	}

}