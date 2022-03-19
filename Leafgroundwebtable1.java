package week4.day1.assignments;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
public class Leafgroundwebtable1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement element = driver.findElement(By.id("table_id"));
		
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		System.out.println("The number of rows is " + rows.size());
		
		WebElement eachrow = rows.get(1);
		List<WebElement> columns = eachrow.findElements(By.tagName("td"));
		System.out.println("The number of columns is " + columns.size());
		
		WebElement row3 = rows.get(3);
		String text = row3.findElement(By.xpath("((//table[@id='table_id']//tr)[3]/td)[2]")).getText();
		System.out.println("The progress value of 'Learn to interact with Elements' is "+text);
		Set<String> percent = new LinkedHashSet<String>();
		List<String> listPercent = new ArrayList<String>();
		for(int i=2;i<=rows.size();i++)
		{
			String text3 = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			
			percent.add(text3);
			
		}
		listPercent.addAll(percent);
		
		System.out.println("The sorted list in descending order");
		
		for(int j=0 ; j<listPercent.size();j++)
		{
		
			System.out.println(listPercent.get(j));
			
		
		}
			
		int size=listPercent.size()-1;
		String leastpercent = listPercent.get(size);
		System.out.println("The Least percentage is " +leastpercent);
		
		for(int i=2;i<=rows.size();i++)
		{
			String checkdata = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			if(leastpercent.equals(checkdata))
			{
				System.out.println("Matching");
				driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[3]/input")).click();
				
			}
		
		}
		
		
		}
	}
	

