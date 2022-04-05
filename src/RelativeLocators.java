import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\GeckoDriver.exe");
		WebDriver driver = new FirefoxDriver();
		//driver.manage().window().maximize();		
		driver.get("https://rahulshettyacademy.com/angularpractice");
		// above() Below() toLeftOf() toRightOf()
		//driver.findElement(withTagName("XX").above(WebElement));
		
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

		WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
	}

}
