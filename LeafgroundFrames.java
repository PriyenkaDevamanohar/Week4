package week4.day1.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leafground.com/pages/frame.html");
		 	
		 driver.manage().window().maximize();
		 driver.switchTo().frame(0);
WebElement firstbutton = driver.findElement(By.xpath("//button[@id='Click']"));
firstbutton.click();
  //Nested frame
driver.switchTo().parentFrame();
driver.switchTo().frame(1);
driver.switchTo().frame("frame2");
driver.findElement(By.id("Click1")).click();
driver.switchTo().defaultContent();

List<WebElement> outerframe = driver.findElements(By.tagName("iframe"));
int count=0;
 count = count+ outerframe.size();
System.out.println(count);
for(int i=0;i<outerframe.size();i++)
{
driver.switchTo().frame(i);

List<WebElement> inner = driver.findElements(By.id("frame2"));
count=count + inner.size();
driver.switchTo().defaultContent();


}
System.out.println("total frames are " + count);
}
}