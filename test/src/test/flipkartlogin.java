package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkartlogin {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepika.keshetty\\Desktop\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.cssSelector("input[className='_2IX_2- VJZDxU']")).sendKeys("7337535992");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("9704593398");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
	}

}
