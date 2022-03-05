import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/"); //Go to Site
		
		//Fill Form
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Ivan Vison");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ivison@rahulshettyacademy.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("youroneanonlyautomator");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticDropdown); 
		dropdown.selectByVisibleText("Male");
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("12011900");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		System.out.println(driver.findElement(By.className("alert-success")).getText());
	}

}
