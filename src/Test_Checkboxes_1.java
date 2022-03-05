import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test_Checkboxes_1 {


	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //Go to Site
		
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
		Thread.sleep(1000);
		System.out.println("There are "+driver.findElements(By.cssSelector("input[type='checkbox']")).size()+" Checkboxes in the site.");

	}

}
