import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CalendarDropdowns {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //Go to Site

		//Click checkbox
		//driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		//Dynamic Dropdowns - FROM: //a[@value='BLR'] to //a[@value='MAA']
		Thread.sleep(5000);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//option[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); // Parent-Child relationship

		//Dates Management
		driver.findElement(By.cssSelector("ui-state-default.ui-state-highlight.ui-state-active")).click();
		
	}

}
//