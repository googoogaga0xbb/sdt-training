import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.util.Strings;

public class StreamWebSort {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\GeckoDriver.exe");
		WebDriver driver = new FirefoxDriver();
		//Maximize Window
		driver.manage().window().maximize();		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture web elements into list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//get text into new list
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort in the list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//Compare both lists
		Assert.assertTrue(originalList.equals(sortedList));
		
		List<String> price;
		
		//Scan name column with getText -> Print price of Beans
		do {
			List<WebElement> rowsList = driver.findElements(By.xpath("//tr/td[1]"));
			price = rowsList.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			if(price.size()<1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		}while(price.size()<1);
		
		
	}
	
	private static String getPriceVeggie(WebElement s ) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
		
	}

}
