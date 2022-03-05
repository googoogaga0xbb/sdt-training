import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//TestNG will be used - ASSERTIONS


public class CheckBoxes {


	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //Go to Site
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
		
		//Number of checkboxes
		//input[type='checkbox']
		//System.out.println("Number of Checkboxes: "+ driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), "6");
	}

}
