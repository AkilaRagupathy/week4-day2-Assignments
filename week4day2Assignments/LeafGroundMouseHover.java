package week4day2Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundMouseHover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*1. Launch the url: https://www.leafground.com/menu.xhtml
		     Menu Bar
		         -Do click on shipment and mousehover on Tracker and Do rightClick on Tracker
		     Slide Menu
		         -Do click Orders and click Back */
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/menu.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement shippment = driver.findElement(By.xpath("(//h3[contains(@class,'ui-widget ui-panelmenu')])[3]/a"));
		Actions act=new Actions(driver);
		act.click(shippment).perform();
		
		WebElement tracter = driver.findElement(By.xpath("(//span[text()='Tracker'])[2]"));
		Actions act1=new Actions(driver);
		act1.moveToElement(tracter).perform();
		
		WebElement rightclick = driver.findElement(By.xpath("(//span[text()='Tracker'])[2]"));
		Actions act2=new Actions(driver);
		act2.contextClick(rightclick).perform();
		
		WebElement orders= driver.findElement(By.xpath("(//span[text()='Orders'])[2]"));
         Actions act3=new Actions(driver);
         act3.click(orders).perform();
         
        // WebElement back = driver.findElement(By.xpath("//div[contains(@class,'ui-slidemenu-backward ui-widget-header')]/span"));
         //Actions act4=new Actions(driver);
         //act4.click(back);
		
		
       		

	}

}
