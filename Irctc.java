package week4.day1.assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Irctc {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.irctc.co.in/");	
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		 String dialog = driver.getWindowHandle();
//		 System.out.println(dialog);
		 WebElement ok = driver.findElement(By.xpath("//button[text()='OK']"));
		 ok.click();
		 //Alert alert = driver.switchTo().alert();
		// alert.dismiss();
//		 WebElement just = driver.findElement(By.xpath("//i[@class='fa fa-align-justify']"));
//		 just.click();
		 //WebElement flightlink = driver.findElement(By.xpath("//label[text()='FLIGHTS']"));
		 WebElement flightlink = driver.findElement(By.linkText("FLIGHTS"));
		 flightlink.click();
		 
		 Set<String> flightwindow = driver.getWindowHandles();
		 System.out.println(flightwindow);
		  
		 Iterator<String> iterator = flightwindow.iterator();
		  String parent = iterator.next();
		  System.out.println(parent);
		  String child = iterator.next();
		  System.out.println(child);
		  driver.switchTo().window(child);
		  WebElement notification = driver.findElement(By.xpath("//button[@class='izooto-optin--cta izooto-optin--cta-later']"));
			 notification.click();
		  WebElement dropdown = driver.findElement(By.id("dropdown10"));
		  dropdown.click();
		  WebElement customercare = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[3]"));
		  System.out.println(customercare.getText());
//		  Select s= new Select(dropdown);
//		  s.selectByIndex(2);
		 //System.out.println(s);
		 driver.switchTo().window(parent);
		 driver.close();
	}

}
