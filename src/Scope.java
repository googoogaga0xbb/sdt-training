import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import java.util.Iterator;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		//driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		//1. Count of the links on the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. Count of the links in the footer section
		//Limiting webdriver scope
		WebElement footerdriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//3.
		//Limiting webdriver scope
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//4. Click on each link in the column and check if the pages are opening
		for (int i=1;i<columndriver.findElements(By.tagName("a")).size(); i++) {
			//Set<String> windows = driver.getWindowHandles(); // [parentID,childID]
			//Iterator<String> it = windows.iterator();
			//String parentId = it.next();
			//driver.switchTo().window(parentId);
			String clickonLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
			Thread.sleep(5000L);
		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
				
		
	}

}