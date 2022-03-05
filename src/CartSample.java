import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSample {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		//GLOBAL DECLARATIONS
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Implicit Wait
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//Explicit Wait- this line and the other one below are regular.
		WebDriverWait w = new WebDriverWait(driver,5);

		// Go to Site
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//Items we want to identify and add to the cart
		//Array list, less memory
		String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Tomato"};

		Thread.sleep(3000);
		addItems(driver, itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//Explicit Wait.
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
	}

	//Creating a method to handle items
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		
		//Picks up all product names and adds them to a list. 
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		//Counter for the break
		int j = 0;		
		
		//We are going through the list of product names and identifying if the product is in our top array
		for (int i = 0; i < products.size(); i++) {
			//Format text - trim
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			
			//Convert array into array list for easy search
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			
			if (itemsNeededList.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				//N times
				if (j== itemsNeeded.length) {
					break;
				}
			}	
		}
	}
	
}