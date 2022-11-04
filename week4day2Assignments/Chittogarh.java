package week4day2Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittogarh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	1. Launch the URL https://www.chittorgarh.com/
			2. Click on stock market
			3. Click on NSE bulk Deals
			4. Get all the Security names
			5. Ensure whether there are duplicate Security names*/
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.chittorgarh.com/");
		driver.findElement(By.xpath("//a[@title='Stock Market']")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		
	List<WebElement>rowsize=driver.findElements(By.xpath("//table[contains(@class,'table-condensed table-striped')]/tbody/tr"));
	
	int rsize = rowsize.size();
	System.out.println("Number of rows: " + rsize);
	
	List<String>securitynames=new ArrayList <String>();
	for (int i = 1; i <= rsize; i++)
	{
		String names=driver.findElement(By.xpath("//table[contains(@class,'table-condensed table-striped')]/tbody/tr["+   i  +"]/td[3]")).getText();
		System.out.println(names);
		securitynames.add(names);
		
	}
		
	Set<String> rowNames = new LinkedHashSet<String>(securitynames);
	
		System.out.println(rowNames);
	

	}

}
