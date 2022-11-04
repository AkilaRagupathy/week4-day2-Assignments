package week4day2Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale.Category;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		/*
		 * Myntra 1) Open https://www.myntra.com/ 2) Mouse hover on MeN 3) Click Jackets
		 * 4) Find the total count of item 5) Validate the sum of categories count
		 * matches 6) Check jackets 7) Click + More option under BRAND 8) Type Duke and
		 * click checkbox 9) Close the pop-up x 10) Confirm all the Coats are of brand
		 * Duke Hint : use List 11) Sort by Better Discount 12) Find the price of first
		 * displayed item Click on the first product 13) Take a screen shot 14) Click on
		 * WishList Now 15) Close Browser
		 */

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Open https://www.myntra.com/

		driver.get("https://www.myntra.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Mouse hover on MeN

		WebElement Brand = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a"));

		Actions act = new Actions(driver);
		act.moveToElement(Brand).perform();

		driver.findElement(By.linkText("Jackets")).click();

		
		WebElement Titlecount = driver.findElement(By.xpath("//span[@class='title-count']"));
		// Titlecount.click();
		String Title = Titlecount.getText();
		System.out.println(Title);

		// Check Jackets
		WebElement CountJackets = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]"));

		String jackets = CountJackets.getText();
		System.out.println(jackets);
		// Click + More option under BRAND

		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		// Type Duke and click checkbox
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		driver.findElement(By.xpath("(//label[@class=' common-customCheckbox']//div)[1]")).click();

		// Close the pop-up x
		driver.findElement(By.xpath("//div[@class='FilterDirectory-titleBar']//span")).click();
		Thread.sleep(3000);

		// Confirm all the Coats are of brand Duke
		List<WebElement> coats = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']"));
		for (WebElement string1 : coats) {
			String Dukecoats = string1.getText();
			System.out.println(Dukecoats);
		}

		// Sort by Better Discount

	//	driver.findElement(By.xpath("//span[text()='Recommended']")).click();
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']")).click();
		driver.findElement(By.xpath("//div[@class='sort-sortBy']")).click();
		
		driver.findElement(By.xpath("//div[@class='sort-sortBy']/span")).click();
		// Find the price of first displayed item

		WebElement Price = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]"));
		String PriceOfJacket = Price.getText();
		System.out.println("Price of First product"+PriceOfJacket);

		// Click on the first product
         driver.findElement(By.xpath("(//div[@class='product-productMetaInfo'])[1]")).click();
         
         Set<String> windowHandles = driver.getWindowHandles();
 		List<String> window=new ArrayList<String>(windowHandles);
 		driver.switchTo().window(window.get(1));
 		Thread.sleep(3000);
 		
         // Take a screen shot
         
         File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
 		File destn=new File("./snap/pic2.jpg");
 		FileUtils.copyFile(screenshotAs, destn);
 		
 		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
 		driver.quit();
 		
 		
	}

}
