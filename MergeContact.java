package week4.day1.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	@Test
	public void runTC005() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		WebElement elementuser = driver.findElement(By.id("username"));
		elementuser.sendKeys("Demosalesmanager");
		WebElement elementpwd = driver.findElement(By.id("password"));
		elementpwd.sendKeys("crmsfa");
		WebElement loginbutton = driver.findElement(By.className("decorativeSubmit"));
		loginbutton.click();
		WebElement link = driver.findElement(By.linkText("CRM/SFA"));
		link.click();
		WebElement contact = driver.findElement(By.linkText("Contacts"));
		contact.click();
		WebElement mergecontact = driver.findElement(By.linkText("Merge Contacts"));
		mergecontact.click();
		String currentwindowHandle = driver.getWindowHandle();
		System.out.println(currentwindowHandle);
		WebElement image1 = driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']"));
		image1.click();
		Thread.sleep(2000);

		Set<String> allWindowHandleSet = driver.getWindowHandles();
		List<String> allWindowHandleList = new ArrayList<String>();
		allWindowHandleList.addAll(allWindowHandleSet);

		String newWindow = allWindowHandleList.get(1);
		driver.switchTo().window(newWindow);

		WebElement firstLink = driver.findElement(By.xpath("//a[@class='linktext']"));
		firstLink.click();

		driver.switchTo().window(currentwindowHandle);

		WebElement image2 = driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]"));
		image2.click();
		Thread.sleep(2000);

		Set<String> allWindowHandleSet2 = driver.getWindowHandles();
		List<String> allWindowHandleList2 = new ArrayList<String>();
		allWindowHandleList2.addAll(allWindowHandleSet2);

		String newWindow2 = allWindowHandleList2.get(1);
		driver.switchTo().window(newWindow2);
		 WebElement towindow = driver.findElement(By.xpath("(//a[@class='linktext'])[6]"));
		 towindow.click();
		 
		 driver.switchTo().window(currentwindowHandle);
		 
		 WebElement mergebutton = driver.findElement(By.xpath("//a[@class='buttonDangerous']"));
		 mergebutton.click();
		 Alert alert = driver.switchTo().alert();
		 System.out.println(alert.getText());
		 alert.accept();
		 Thread.sleep(10000);
		 System.out.println(driver.getTitle());
		 
		 if(driver.getTitle().equals("View Contact | opentaps CRM"))
		 {
			 System.out.println("The title is View Contact");
		 }
		 else
		 {
			 System.out.println("No such page is found");
			 
		 }
		 
		 driver.quit();
		 

	}

}
