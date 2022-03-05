import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //Go to Site

		
		//Click checkbox
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		//Know if enabled
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("It's Disabled");
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
		}
		
		//Dynamic Dropdowns - FROM: //a[@value='BLR'] to //a[@value='MAA']
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//option[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); // Parent-Child relationship

		//div [@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']
		
		//driver.findElement(By.className("select_CTXT")).click(); 
		//driver.findElement(By.xpath("//a[@value='MAA']")).click();
		
		//Dates Management - Opening Depart Date and clicking Highlighted date
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		//Loop UI Dropdown
		//WebElement passengersDropdown = driver.findElement(By.id("divpaxinfo"));
		//Select passengers = new Select(passengersDropdown);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		int i = 1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//Dropdown with Select Tag // CURRENCY
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown); 
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		
		//Checkboxes - 
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
		//Number of checkboxes
		//input[type='checkbox']
		//System.out.println("Number of Checkboxes: "+ driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), "6");
	}

}
//