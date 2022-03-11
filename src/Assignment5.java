import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(("https://the-internet.herokuapp.com/"));
		driver.findElement(By.partialLinkText("Frames")).click();
		driver.findElement(By.partialLinkText("Nested Frames")).click();
		
		//Find the amount of frames
		System.out.println(driver.findElements(By.tagName("frame")).size());
		
		//Switch to top-frame
		driver.switchTo().frame(0);
		System.out.println(driver.findElements(By.tagName("frame")).size());
		
		//Switch to middle frame
		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.id("content")).getText());
		
		driver.switchTo().defaultContent();
	}

}
