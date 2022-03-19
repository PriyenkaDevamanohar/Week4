package week4.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChercherFrames {

	@Test
	public void runTC006() {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		 	
		 driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.switchTo().frame("frame1");
		 
		 //driver.findElement(By.id("topic")).sendKeys("hello",Keys.getKeyFromUnicode($0));
		 driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Hello text");
		 //driver.switchTo().defaultContent();
		 driver.switchTo().frame("frame3");
		 driver.findElement(By.id("a")).click();
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame("frame2");
		 WebElement drop = driver.findElement(By.id("animals"));
		 Select animal = new Select(drop);
		 animal.selectByVisibleText("Big Baby Cat");
		 System.out.println(animal);

	}

}
