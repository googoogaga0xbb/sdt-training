import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		String name = "ivan";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Implicit Wait - 5 Seconds time out
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); //Go to Site
		driver.findElement(By.id("inputUsername")).sendKeys(name);  //Locate Input and enter information
		driver.findElement(By.name("inputPassword")).sendKeys(password);  //Locate Input and enter information
		driver.findElement(By.className("submit")).click(); //Locate Button and click
		
		//Validation
		Thread.sleep(2000); // Wait
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Hello "+name+",");
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		//driver.findElement(By.className("logout-btn")).click(); //Locate Button and click
		driver.findElement(By.xpath("//button[text()='Log Out']")).click(); //Locate Button and click - identify by text in the button
		driver.close();
		
	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); //Go to Site
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000); // Wait
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ivan"); //Write Name
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("ivan@ivan.com"); // Write Email
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("8888888888"); // Write Phone
		driver.findElement(By.className("reset-pwd-btn")).click(); //Locate Button and click
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordArray = passwordText.split("'"); // this will create array with 0 and 1 index
		//[0] = Please use temporary password '
		//[1] = rahulshettyacademy' to Login.
		String password = passwordArray[1].split("'")[0];
		return password;
		
	}
	
}
