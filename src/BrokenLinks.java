import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		

		//Step 1 is to get all URL's - Using selenium
		//String url = driver.findElement(By.cssSelector("a[href*='broken']")).getAttribute("href");
		//Step 2 Java Methods will call URL's and gets you the status code, Status > 400, broken 
		//HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
		//connection.setRequestMethod("HEAD");
		//connection.connect();
		//int respCode = connection.getResponseCode();
		//System.out.println(respCode);
		
		//Iterate over all links li[class='gi-li']
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert sa = new SoftAssert();
		
		for(WebElement link : links) {
			//Step 1 is to get all URL's - Using selenium
			String url = link.getAttribute("href");
			//Step 2 Java Methods will call URL's and gets you the status code, Status > 400, broken 
			HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int respCode = connection.getResponseCode();
			
			//Hard Assertion.
			//Assert.assertTrue(respCode<400, "The broken link text is: "+ link.getText() +" with code "+ respCode);
			
			//Soft Assertion
			sa.assertTrue(respCode<400, "The broken link text is: "+ link.getText() +" with code "+ respCode);
			//if(respCode > 400) {
				//System.out.println("The broken link text is: "+ link.getText() +" with code "+ respCode);
				//Hard Assertion
				//Assert.assertTrue(false);
				//Soft Assert
				
			}
		
		sa.assertAll();
		
		}
		
		//driver.quit();

}



