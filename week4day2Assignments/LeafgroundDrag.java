package week4day2Assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import com.mongodb.client.model.geojson.Point;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundDrag {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		 * 2.Launch the url : https://www.leafground.com/drag.xhtml Draggable Columns
		 * -Move the Column Name to Column Quanity -Get the Toaster message to confirm
		 * it Draggable Rows -Move the row 3 to row 4 -Get the Toaster message to
		 * confirm it Resize Image -Resize the message and Verify it Range Slider -Give
		 * a range between 10 and 80 (use movebyOffset() for x values ,y should be 0 and
		 * use negative value for right move)
		 */

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		

		WebElement columnsource= driver.findElement(By.xpath("(//table//th[@role='columnheader'])[1]"));
		WebElement columntarget = driver.findElement(By.xpath("(//table//th[@scope='col'])[3]"));
		//Point location = columnsource.getLocation();
		//int x = location.getX();
		//int y = location.getY();

		Actions act = new Actions(driver);
		act.moveToElement(columntarget).dragAndDrop(columntarget, columnsource).perform();
		Thread.sleep(3000);
		
	  // String text =driver.findElement(By.xpath("//span[text()='Columns reordered']")).getText();
		//System.out.println(text);
		
		
		
		WebElement rowsource = driver.findElement(By.xpath("(//table [@role='grid'])[2]/tbody/tr[3]/td[1]"));
		WebElement rowtarget =  driver.findElement(By.xpath("(//table [@role='grid'])[2]/tbody/tr[4]/td[1]"));
		//Point location = rowtarget.getLocation();
		//int x = location.getX();
		//int y = location.getY();

		
		Actions act1=new Actions(driver);
		act1.moveToElement(rowtarget).dragAndDrop(rowtarget, rowsource).perform();
		Thread.sleep(3000);
		
		
	}

}
