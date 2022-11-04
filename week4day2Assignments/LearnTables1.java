package week4day2Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnTables1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		/*	1. Launch the URL https://html.com/tags/table/
			2. Get the count of number of rows
			3. Get the count of number of columns*/
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://html.com/tags/table/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> rowSize=	driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr"));
		
		int rsize = rowSize.size();
		System.out.println("Number of rows: " + rsize);
		
		List<WebElement> colsize=driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr/th"));
		
        int csize=colsize.size();
        System.out.println("Number of columns "+csize);


	}

}
