import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		//Pull Elements
		//1. Columns
		List<WebElement> colHeader = driver.findElements(By.xpath("//table[@id='product'][@name='courses']//th"));
		System.out.println("The amount of Columns is: " + colHeader.size());
		
		//2. Rows
		System.out.println("The amount of Rows is: " + driver.findElements(By.xpath("//table[@id='product'][@name='courses']//tr")).size());
		
		//Print 2nd Row Content
		List<WebElement> rowContent = driver.findElements(By.xpath("//table[@id='product'][@name='courses']//tr[3]//td"));
		
		for (int i = 0; i < rowContent.size(); i++) {
			System.out.println(colHeader.get(i).getText() + ": " + rowContent.get(i).getText());
			//System.out.println(driver.findElement(By.xpath("//table[@id='product'][@name='courses']//tr[3]//td"))(i).getText());
		}
			
		
	}

}
