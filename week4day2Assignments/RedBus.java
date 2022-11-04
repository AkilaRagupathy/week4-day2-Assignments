package week4day2Assignments;

import java.time.Duration;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Step:1-Launch the url (https://www.redbus.in/) Step:2-Enter From -Madiwala
		 * Bangalore Step:3-Enter To Koyambedu Chennai Step:4-Select the Date
		 * 30-September-2022 Step:5-Print the Title of the page
		 */

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.redbus.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("src")).sendKeys("Madiwala Bangalore");
		driver.findElement(By.id("dest")).sendKeys("Koyambedu Chennai");
		driver.findElement(By.xpath("//span[contains(@class,'fl icon-calendar_icon-new')]")).click();
		driver.findElement(By.xpath("//table//tr//td[@class='current day']")).click();
		System.out.println(driver.getTitle());

	}

}
