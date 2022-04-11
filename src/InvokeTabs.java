import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeTabs {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		//driver.manage().window().maximize();

		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iter = handles.iterator();
		String parentWindowId = iter.next();
		String childWindowId = iter.next();
		
		driver.switchTo().window(childWindowId);
		driver.get("https://www.rahulshettyacademy.com/");
		
		Thread.sleep(5000);
		String courseTitle = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		driver.switchTo().window(parentWindowId);
		WebElement name = driver.findElement(By.cssSelector("input[name*='name']"));
		name.sendKeys(courseTitle);
		driver.switchTo().window(childWindowId);
		driver.close();
		driver.switchTo().window(parentWindowId);
		
		//CaptureScreenShot // Web Element
		//Needs: https://mvnrepository.com/artifact/commons-io/commons-i
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		//Getting Height and Width of a WebElement
		
		Integer height = name.getRect().getDimension().getHeight();
		Integer width = name.getRect().getDimension().getWidth();
		
		System.out.println("Width: " + width + " Heigh: " + height);

		Thread.sleep(5000);
		driver.quit();
	}

}
