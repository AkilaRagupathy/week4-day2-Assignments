package week4day2Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*
		 * 1.Load the uRL https://www.amazon.in/ 2.search as oneplus 9 pro 3.Get the
		 * price of the first product 4. Print the number of customer ratings for the
		 * first displayed product 5. Mouse Hover on the stars 6. Get the percentage of
		 * ratings for the 5 star. 7. Click the first text link of the first image 8.
		 * Take a screen shot of the product displayed 9. Click 'Add to Cart' button 10.
		 * Get the cart subtotal and verify if it is correct.
		 */

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement input=driver.findElement(By.name("field-keywords"));
           input.sendKeys("oneplus 9 pro",Keys.ENTER);
           
           
		WebElement price = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
		String PhonePrice = price.getText();
		System.out.println(PhonePrice);
		
		driver.findElement(By.xpath("(//a[@role='button']//i)[2]")).click();

		WebElement star = driver.findElement(By.xpath("//span[@data-hook='acr-average-stars-rating-text']"));
		String CustomerRating = star.getText();
		System.out.println(CustomerRating);
		
		WebElement percen=driver.findElement(By.xpath("(//span[@class='a-size-base'])[2]/a"));
       String percentage=percen.getText();
       System.out.println(percentage);
		
		WebElement mouseover=driver.findElement(By.xpath("(//a[@class='a-popover-trigger a-declarative']/i)[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(mouseover).perform();
		
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window=new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File destn=new File("./snap/pic1.jpg");
		FileUtils.copyFile(screenshotAs, destn);
		
		
		
	}

}
