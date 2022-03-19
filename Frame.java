package week4.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.switchTo().frame("iframeResult");
		WebElement element = driver.findElement(By.xpath("//button[text()='Try it']"));
		element.click();
	org.openqa.selenium.Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("Priyenka");
		System.out.println(alert.getText());
		alert.accept();
		String text = driver.findElement(By.id("demo")).getText();
		if(text.contains("Priyenka"))
		{
			System.out.println("Match is found");
		}
		else {
			System.out.println("Not Matched");
		}
	}
}
		
//		WebDriver id = driver.switchTo().frame("demo");
//		id.getTitle();
//		
//		

	


