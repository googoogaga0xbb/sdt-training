import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(); // Open Chrome Browser
		//driver.manage().window().maximize();
		driver.get("https://ant.design/components/date-picker/"); // Go to Site
		
		driver.findElement(By.xpath("//div[@class='ant-picker-input']")).click();
		Thread.sleep(3000);
		
		
		while (!driver.findElement(By.xpath("//div[@class='ant-picker-header-view']")).getText().contains("Jun")) {
			driver.findElement(By.xpath("//button[@class='ant-picker-header-next-btn']")).click();
		}
		
		
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='ant-picker-cell-inner']")); //ant-picker-cell-inner
		
		int count = driver.findElements(By.xpath("//div[@class='ant-picker-cell-inner']")).size();
		
		for (int i=0; i < count; i++) {
			String text=driver.findElements(By.xpath("//div[@class='ant-picker-cell-inner']")).get(i).getText();
			if(text.equalsIgnoreCase("23")) {
				driver.findElements(By.xpath("//div[@class='ant-picker-cell-inner']")).get(i).click();
				break;
			}
		}
			

	}

}
