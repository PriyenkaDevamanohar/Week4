package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQuerysample {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://jqueryui.com/droppable/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 //Drag and Drop
		 WebElement drop1 =driver.findElement(By.linkText("Droppable"));
		 drop1.click();
		 driver.switchTo().frame(0);
		 WebElement element = driver.findElement(By.id("draggable"));
		 WebElement drop = driver.findElement(By.id("droppable"));
		 Actions act = new Actions(driver);
		 act.dragAndDrop(element, drop).perform();
		 System.out.println("Good");
		 //Resizeable
		 driver.switchTo().parentFrame();
		 
		WebElement resize= driver.findElement(By.linkText("Resizable"));
		resize.click();
		driver.switchTo().frame(0);
		WebElement move = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		Actions strech = new Actions(driver);
		strech.dragAndDropBy(move, 100, 100).perform();
		System.out.println("Perfect");
		
		//Drag
		driver.switchTo().parentFrame();
		WebElement drag =driver.findElement(By.linkText("Draggable"));
		drag.click();
		driver.switchTo().frame(0);
		WebElement dragid = driver.findElement(By.id("draggable"));
		Actions dragging = new Actions(driver);
		 dragging.dragAndDropBy(dragid, 200, 100).perform();
		 
		 //Selectable
		 
		   driver.switchTo().parentFrame();
			WebElement select =driver.findElement(By.linkText("Selectable"));
			select.click();
			driver.switchTo().frame(0);
			WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
			WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
			WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 4']"));
			//item1.click();
			Actions firstitem = new Actions(driver);
			//firstitem.moveToElement(item1).click();
			firstitem.keyDown(Keys.CONTROL).click(item1).click(item2).click(item3).build().perform();
			System.out.println("Done");
			//Sortable
			driver.switchTo().parentFrame();
			String currentwindowHandle = driver.getWindowHandle();
			System.out.println(currentwindowHandle);
			WebElement sort =driver.findElement(By.linkText("Sortable"));
			sort.click();
			Set<String> allWindowHandleSet = driver.getWindowHandles();
			List<String> allWindowHandleList = new ArrayList<String>();
			allWindowHandleList.addAll(allWindowHandleSet);

			String newWindow = allWindowHandleList.get(1);
			driver.switchTo().window(newWindow);
			driver.switchTo().frame(0);
			Actions items = new Actions(driver);
			//Thread.sleep(2000);
			WebElement no1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
			WebElement no2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
			items.click(no1).clickAndHold().moveToElement(no2).moveByOffset(10,20).release().perform();
			
			
			
			
			//builder.click(drag).clickAndHold().moveToElement(drop).moveByOffset(0, 10).release().perform();
		
		

	}

}
