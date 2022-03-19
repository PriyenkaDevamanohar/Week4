package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explicitwaitforappear {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/appear.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement allbuttons = driver.findElement(By.id("btn"));
		//System.out.println(allbuttons.getText());
		WebDriverWait appear = new WebDriverWait(driver,Duration.ofSeconds(10));
		appear.until(ExpectedConditions.visibilityOf(allbuttons));
		System.out.println(allbuttons.getText());
		
	}

}
