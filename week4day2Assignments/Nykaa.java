package week4day2Assignments;

import java.time.Duration;
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
		// TODO Auto-generated method stub

		/*
		 * 1) Go to https://www.nykaa.com/ 2) Mouseover on Brands and Search L'Oreal
		 * Paris 3) Click L'Oreal Paris 4) Check the title contains L'Oreal
		 * Paris(Hint-GetTitle) 5) Click sort By and select customer top rated 6) Click
		 * Category and click Hair->Click haircare->Shampoo 7) Click->Concern->Color
		 * Protection 8)check whether the Filter is applied with Shampoo 9) Click on
		 * L'Oreal Paris Colour Protect Shampoo 10) GO to the new window and select size
		 * as 175ml 11) Print the MRP of the product 
		 * 12) Click on ADD to BAG
		 *  13) Go to
		 * Shopping Bag 14) Print the Grand Total amount 15) Click Proceed 16) Click on
		 * Continue as Guest 17) Check if this grand total is the same in step 14 18)
		 * Close all windows
		 */

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.nykaa.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement Brand = driver.findElement(By.xpath("//a[text()='brands']"));

		Actions act = new Actions(driver);
		act.moveToElement(Brand).perform();

		WebElement Name = driver.findElement(By.xpath("//div[@id='scroller-container']/div[7]/a[1]"));
		Name.click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//div[@class='css-0']//button[1]")).click();

		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

		driver.findElement(By.xpath("//div[@class='css-w2222k']//div")).click();
		driver.findElement(By.xpath("(//div[@class=' css-b5p5ep'])[2]")).click();
		driver.findElement(By.xpath("(//li[@class='css-1do4irw']//div)[2]")).click();
		driver.findElement(By.xpath("(//div[@class='control-value']//span)[2]")).click();
		driver.findElement(By.xpath("//div[@id='filters-strip']/div[1]/div[1]/div[5]/div[1]")).click();

		WebElement filtershampoo = driver.findElement(By.xpath("//span[@class='filter-value']"));
		String filter = filtershampoo.getText();
		System.out.println(filter);

		driver.findElement(By.xpath("//div[@id='product-list-wrap']/div[7]/div[1]/div[1]/a[1]/div[2]/div[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);

		driver.switchTo().window(window.get(1));
		WebElement sizeSelect = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select ml = new Select(sizeSelect);

		WebElement mrp = driver.findElement(By.xpath("//span[@class='css-1jczs19']"));
		String printmrp = mrp.getText();
		System.out.println("MRP   "+printmrp);
		
		driver.findElement(By.xpath("//div[@class='css-vp18r8']//button[1]")).click();
		
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		driver.switchTo().frame(0);
		
		WebElement grandtotal=driver.findElement(By.xpath("//div[@class='css-15py5ir e25lf6d2']/span"));
		String printtotal=grandtotal.getText();
		System.out.println("GRANDTOTAL  "+printtotal);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='css-ltzjhp e25lf6d7']/button")).click();
		
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		
		WebElement GrandTotal=driver.findElement(By.xpath("//p[@class='css-5t7v9l eka6zu20']"));
		String GrandTot=GrandTotal.getText();
		System.out.println("Grandtotal is   "+GrandTot);
		
		if(printtotal.equals(GrandTot))
		{
			System.out.println("GrandTotal is same");
		}
		
		
		driver.quit();
	}

}
