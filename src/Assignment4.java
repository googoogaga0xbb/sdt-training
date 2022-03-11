import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(("https://the-internet.herokuapp.com/"));
		driver.findElement(By.partialLinkText("Multiple Windows")).click();
		driver.findElement(By.partialLinkText("Click Here")).click();
		
		//Identify Opened Windows
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		//Switch to Child Window and print
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector(".example")).getText());
		
		//Switch to parent window and print
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
	}

}
