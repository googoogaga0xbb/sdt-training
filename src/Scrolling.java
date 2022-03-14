import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		//driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		//Scrolling
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//Table - //td[4]   //CSS: td:nth-child(4)
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum = 0;
		for(int i=0; i<values.size(); i++) {
			sum = sum + Integer.parseInt(values.get(i).getText());
			System.out.println(Integer.parseInt(values.get(i).getText()));
		}
		System.out.println(driver.findElement(By.className("totalAmount")).getText());
		System.out.println("The total amount of the SUM = " + sum);
		
		int totalAmt = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, totalAmt);
		
		
		
		
		
	}

}
