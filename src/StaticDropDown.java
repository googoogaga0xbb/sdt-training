import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //Go to Site

		//Dropdown with Select Tag
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown); 
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
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
		/*for(int i=1;1<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			Thread.sleep(1000);
		}*/

		driver.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
	}

}
