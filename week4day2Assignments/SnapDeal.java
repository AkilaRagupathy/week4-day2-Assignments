package week4day2Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		 * 1. Launch https://www.snapdeal.com/ 2. Go to Mens Fashion 3. Go to Sports
		 * Shoes 4. Get the count of the sports shoes 5. Click Training shoes 6. Sort by
		 * Low to High 7. Check if the items displayed are sorted correctly 8.Select the
		 * price range (900-1200) 9.Filter with color Navy 10 verify the all applied
		 * filters 11. Mouse Hover on first resulting Training shoes 12. click QuickView
		 * button 13. Print the cost and the discount percentage 14. Take the snapshot
		 * of the shoes. 15. Close the current window 16. Close the main window
		 */

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.snapdeal.com/");
		// Go to Mens Fashion

		WebElement MensFashion = driver.findElement(By.linkText("Men's Fashion"));

		Actions act = new Actions(driver);
		act.moveToElement(MensFashion).perform();
		// Go to Sports Shoes
		driver.findElement(By.xpath("//span[@class='linkTest']")).click();
		
		//Get the count of the sports shoes
		WebElement count=driver.findElement(By.xpath("//span[contains(@class,'category-count')]"));
		String SportShoeCount=count.getText();
		System.out.println(SportShoeCount);
		
		//. Click Training shoes
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		// Sort by * Low to High
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		driver.findElement(By.xpath("(//li[contains(@data-index,'1')])[2]")).click();
		 // Check if the items displayed are sorted correctly 
		

	}

}
