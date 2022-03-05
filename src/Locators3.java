import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser

		//Siblings - Child to Parent traverse
		//header/div/button[1]   -< Relay to Xapth
		//header/div/button[1]/following-sibling::button[1]  <--- traverse
		//parent to child --- child to sibling
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //Go to Site
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		//Travel from Child to Parent -- //header/div/button[1]/parent::div/parent::header/a
		// Parent to child to parent to parent to child
	}
}
