import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class fluentWait {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");

		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/"); //Go to Site
		driver.findElement(By.partialLinkText("Dynamic Loading")).click();
		driver.findElement(By.partialLinkText("Example 1")).click();
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		    	 if (driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed()) {
		    		 return driver.findElement(By.xpath("//div[@id='finish']/h4"));
		    	 }
		    	 else
		    		 return null;
		     }
		   });
		
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
	}

}
