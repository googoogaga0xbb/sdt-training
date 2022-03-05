import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AAtest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		//driver.manage().window().maximize();
		driver.get("https://www.aa.com.do/homePage.do?locale=es_DO"); //Go to Site
		
		Thread.sleep(500);
		//Click Checkbox to Close main popup
		driver.findElement(By.xpath("//input[@id='aa_optoutmulti_checkBox']")).click();
		Thread.sleep(500);
		driver.findElement(By.className("optoutmulti_button")).click();
		Thread.sleep(500);
		
		//Look for airport destination
		driver.findElement(By.xpath("//a[@data-for='reservationFlightSearchForm.destinationAirport']//span[@class='icon icon-search']")).click();
		Thread.sleep(500);
		
		//Select Country Code
		driver.findElement(By.id("countryCode")).click();
			WebElement countrycodes = driver.findElement(By.id("countryCode"));
			Select country = new Select(countrycodes); 
			country.selectByValue("US");
		
		//Select State Code
		Thread.sleep(1000);
		driver.findElement(By.id("stateCode")).click();
			WebElement statecodes = driver.findElement(By.id("stateCode"));
			Select state = new Select(statecodes); 
			state.selectByValue("NY");
		
		//Look for JFK airport and click
		Thread.sleep(1000);
		driver.findElement(By.id("airport_JFK")).click();
		Thread.sleep(1000);
		
		//Select Passengers
		driver.findElement(By.id("flightSearchForm.adultOrSeniorPassengerCount")).click();
		Thread.sleep(500);
		WebElement passengers = driver.findElement(By.id("flightSearchForm.adultOrSeniorPassengerCount"));
		Select passenger = new Select(passengers); 
		passenger.selectByValue("2");
		
		//Select Date - Departure
		driver.findElement(By.className("ui-datepicker-trigger")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-hover']")).click();
		Thread.sleep(1000);
		//Select Date - Return		
		driver.findElement(By.xpath("//input[@name='returnDate']")).sendKeys("29/01/2022");
		Thread.sleep(1000);
		
		//Since the submit button is not Interactable, found this in the internet - To wait for the element to become available 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit'][contains(@value,'Buscar vuelos')]")));
		ele.click();		
	}

}
