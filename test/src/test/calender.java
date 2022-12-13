package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\deepika.keshetty\\Desktop\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		/*
		 * driver.get("https://www.path2usa.com/travel-companions");
		 * driver.findElement(By.id("form-field-travel_comp_date")).click();
		 * 
		 * while(!driver.findElement(By.cssSelector(".flatpickr-current-month")).getText
		 * ().contains("January")) {
		 * driver.findElement(By.cssSelector(".flatpickr-next-month")).click(); }
		 */
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.cssSelector("div[class*='dates']")).click();
		driver.findElements(By.xpath("//div[@class='DayPicker-Month']/div[@class='DayPicker-Caption']"));
		
		while(!driver.findElements(By.xpath("//div[@class='DayPicker-Month']/div[@class='DayPicker-Caption']")).get(1).getText().contains("January"))
		{
			driver.findElement(By.cssSelector("span[class*='DayPicker-NavButton--next']")).click();
		}

	}

}
