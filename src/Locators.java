import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Implicit Wait - 5 Seconds time out
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); //Go to Site
		driver.findElement(By.id("inputUsername")).sendKeys("ivan");  //Locate Input and enter information
		driver.findElement(By.name("inputPassword")).sendKeys("123");  //Locate Input and enter information
		driver.findElement(By.className("submit")).click(); //Locate Button and click
		
		//CSS Selector --- 
		// Example: tagname[attribute='value']     input[placeholder='Username'] --- if there's no ID or Classname or any of the other locators
		// tagname.classname   ex. p.error
		//tagname#idname
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//LinkText
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//Xpath -- When no attribute is given the way above
		//input[@placeholder='Name']
		//input[@placeholder='Email']
		//input[@placeholder='Phone Number']
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ivan"); //Write Name
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("ivan@ivan.com"); // Write Email
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear(); // Clear Email Field
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("ivan2@ivan.com"); // Write New Email
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("8888888888"); // Write Phone
		driver.findElement(By.className("reset-pwd-btn")).click(); //Locate Button and click
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click(); //Locate go back to login Button and click
		Thread.sleep(2000); // Wait
		driver.findElement(By.id("inputUsername")).sendKeys("ivan");  //Locate Input and enter information
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");  //Locate Input and enter information		
		driver.findElement(By.className("submit")).click(); //Locate Button and click
		
		//driver.findElement(By.className("logout-btn")).click(); //Locate Button and click
		driver.findElement(By.xpath("//button[text()='Log Out']")).click(); //Locate Button and click - identify by text in the button
		driver.close();
	}


	
}
