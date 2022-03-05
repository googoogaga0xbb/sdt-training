import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selintroduction {

	public static void main(String[] args) {
		
		// Invoking Browser
		// Chrome -  ChromeDriver -> Methods close get
		// Firefox - FirefoxDriver -> Methods close get -- geckodriver
		// WebDrivers Methods with empty bodies. Responsible to implement methods 
				
		//Path to Chromedriver  -https://chromedriver.chromium.org/downloads
		//webdriver.chrome.driver->Value of the Path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser

		//Path to Firefoxdriver  - https://github.com/mozilla/geckodriver/releases
		//webdriver.gecko.driver->Value of the Path
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\GeckoDriver.exe");
		//WebDriver driver = new GeckoDriver(); // Open Firefox Browser
		
		//Path to Edgedriver  -https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
		//webdriver.edge.driver->Value of the Path
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\msedgedriver.exe");
		//WebDriver driver = new EdgeDriver(); // Open Edge Browser
		
		driver.get("https://bettyperez.net/"); // Go to the URL 
		System.out.println("IV-TESTING");
		System.out.println(driver.getTitle()); //Get the title and print it in the console
		System.out.println(driver.getCurrentUrl()); // Get the Current URL and print it in the console
		driver.close(); //Close the Browser and the //driver.quit(); will close all associated windows
		
		

	}

}
