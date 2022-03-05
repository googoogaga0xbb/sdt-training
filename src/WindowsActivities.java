import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsActivities {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice"); //Go to Site
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice"); // get will wait to full load. Navigate wont wait
		driver.navigate().back();
		driver.navigate().forward();
		
	}

}
