package week4.day1.assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		 driver.get(" https://www.amazon.in/");	
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		 WebElement price = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
		 System.out.println("The price is " + price.getText());
		 WebElement totalcustomers = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']"));
		 System.out.println("Total no.of.customers " + totalcustomers.getText());
		 //driver.findElement(By.xpath("//i[@class='a-icon a-icon-popover']")).click();
		 //WebElement percent = driver.findElement(By.xpath("//span[@class='a-link-normal']"));
		 //System.out.println("the percentage" + percent.getText());
//		 String currentwindowHandle = driver.getWindowHandle();
//			System.out.println(currentwindowHandle);
		 WebElement firstlink = driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
		 System.out.println("the first link is " + firstlink.getText());
		 firstlink.click();
		 Thread.sleep(2000);
		 Set<String> window = driver.getWindowHandles();
		 System.out.println(window);
		  
		 Iterator<String> iterator = window.iterator();
		  String parent = iterator.next();
		  System.out.println(parent);
		  String child = iterator.next();
		  System.out.println(child);
		  driver.switchTo().window(child);
//		 Set<String> allWindowHandleSet = driver.getWindowHandles();
//			List<String> allWindowHandleList = new ArrayList<String>();
//			allWindowHandleList.addAll(allWindowHandleSet);
			//Thread.sleep(2000);
		  WebElement finalamount = driver.findElement(By.id("add-to-cart-button"));
		  finalamount.click();
		  if(price.equals(finalamount))
		  {
			  System.out.println("Correct");
		  }
		  else
		  {
			  System.out.println("Incorrect");
		  }
		  
		 //addtocart.click();
		 //driver.close();

	}

}
