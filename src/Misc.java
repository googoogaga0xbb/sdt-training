import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

public class Misc {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		//Maximize Window
		driver.manage().window().maximize();
		
		//Delete Cookies
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("sessionKey");
		
		driver.get("https://the-internet.herokuapp.com");
		System.out.println(driver.getTitle());
		
		//Take a screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C://Users//Ivan//Desktop//screenshot.png"));
		
		
		//driver.quit();

	}

}
