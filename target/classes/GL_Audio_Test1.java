import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class GL_Audio_Test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");

		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().window().maximize();
		driver.get("https://cp.greenlinknetworks.com/"); //Go to Site
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver,15);
		
		//LOGIN
		driver.findElement(By.id("_username")).sendKeys("yourusername");
		driver.findElement(By.id("password")).sendKeys("yourpassword");
		driver.findElement(By.name("_remember_me")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Global Call Log")));
		driver.findElement(By.partialLinkText("Global Call Log")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-sm call-recording-listen']")));
		driver.findElement(By.xpath("//button[@class='btn btn-sm call-recording-listen']")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("player")));
		
		Thread.sleep(3000);
		WebElement audio = driver.findElement(By.tagName("audio"));
		try {
			Assert.assertNotEquals(audio.getAttribute("currentTime"), "0");
			System.out.println("Audio is Playing");
			driver.quit();
		} 
		catch(AssertionError e) {
			System.out.println("Audio not working");
			driver.quit();
		}
			

	}

}
