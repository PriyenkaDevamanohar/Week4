package week4.day1.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.nykaa.com/");	
		 driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 WebElement mouseoveronbrands = driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
		 Actions action = new Actions(driver);
		 action.moveToElement(mouseoveronbrands).clickAndHold().build().perform();
		 Thread.sleep(2000);
		 WebElement searchbox = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		 searchbox.click();
		 searchbox.sendKeys("Loreal");
		 Thread.sleep(2000);
		 WebElement loreal = driver.findElement(By.linkText("L'Oreal Paris"));
		 loreal.click();

		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		WebElement downarrow = driver.findElement(By.xpath("//span[@class='sort-name']"));
		downarrow.click();
		//action.clickAndHold(downarrow).build().perform();
		
		WebElement customerrated = driver.findElement(By.xpath("(//span[@class='title'])[4]"));
		customerrated.click();
		System.out.println(customerrated);
		 
		WebElement category = driver.findElement(By.xpath("//span[@class='title ']"));
		category .click();
		Thread.sleep(2000);

		WebElement hair = driver.findElement(By.xpath("(//span[@class='filter-name '])[2]"));
		hair .click();
		
		WebElement haircare = driver.findElement(By.xpath("//span[@class='filter-name ']"));
		haircare .click();
		WebElement shampoo = driver.findElement(By.xpath("//div[@class='control-indicator checkbox ']"));
		shampoo .click();
		WebElement concern = driver.findElement(By.xpath("(//span[@class='title '])[5]"));
		concern .click();
		Thread.sleep(2000);
		
		WebElement colorprotection = driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[9]"));
		colorprotection .click();
		
		Thread.sleep(2000);
		String currentwindowHandle = driver.getWindowHandle();
		System.out.println(currentwindowHandle);
		
		WebElement colorprotectshampoo = driver.findElement(By.xpath("//div[@class='css-xrzmfa']"));
		colorprotectshampoo .click();
		Set<String> allWindowHandleSet = driver.getWindowHandles();
		List<String> allWindowHandleList = new ArrayList<String>();
		allWindowHandleList.addAll(allWindowHandleSet);

		String newWindow = allWindowHandleList.get(1);
		driver.switchTo().window(newWindow);
		WebElement quantity = driver.findElement(By.xpath("//select[@class='css-2t5nwu']"));
		quantity.click();
		Select s = new Select(quantity);
		s.selectByIndex(0);
		quantity.sendKeys(Keys.ENTER);
		
		WebElement mrp = driver.findElement(By.xpath("//div[@class='css-1d0jf8e']"));
		System.out.println(mrp.getText());
		
		WebElement addtocart = driver.findElement(By.xpath(" //button[@class=' css-n03g1c']"));
		addtocart.click();
		
		
		WebElement shoppingbag = driver.findElement(By.xpath("//button[@class='css-g4vs13']"));
		shoppingbag.click();
		
	/*	Set<String> allWindowHandleSet2 = driver.getWindowHandles();
		List<String> allWindowHandleList2 = new ArrayList<String>();
		allWindowHandleList2.addAll(allWindowHandleSet2);
		String proceedWindow = allWindowHandleList2.get(1);
		driver.switchTo().window(proceedWindow);*/
		
		WebElement grand = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(grand);
		WebElement grandtotal = driver.findElement(By.xpath("//div[@class='table-row ']"));
		System.out.println(grandtotal.getText());
		
		WebElement proceed = driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']"));
		proceed.click();
		
		WebElement continueasguest = driver.findElement(By.xpath("//button[@class='btn full big']"));
		continueasguest.click();
		
		WebElement total = driver.findElement(By.xpath("(//div[@class='value'])[2]"));
		System.out.println(total);
		
		if(total.equals(grandtotal))
		{
			System.out.println("Total is Same");
		}
		else
		{
			System.out.println("Not same");
		}
		driver.quit();

	}

}
/*Click Category and click Hair->Click haircare->Shampoo
7) Click->Concern->Color Protection
8)check whether the Filter is applied with Shampoo
9) Click on L'Oreal Paris Colour Protect Shampoo
10) GO to the new window and select size as 175ml
11) Print the MRP of the product
12) Click on ADD to BAG
13) Go to Shopping Bag 
14) Print the Grand Total amount
15) Click Proceed
16) Click on Continue as Guest
17) Check if this grand total is the same in step 14
18) Close all windows
 */