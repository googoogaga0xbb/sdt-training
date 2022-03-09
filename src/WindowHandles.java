import java.util.Set;
import java.util.iterator;
import javax.swing.text.html.HTMLDocument.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Strings;

public class WindowHandles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().window().maximize();

		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		//Identify opened windows [parent and Child]
		Set<String> windows = driver.getWindowHandles();
		
		//Determine the amount of opened windows
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		
		
		//Switch windows
		driver.switchTo().window(arg0);
		
		
		
	}

}
