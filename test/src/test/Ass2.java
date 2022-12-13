package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ass2 {
	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepika.keshetty\\Desktop\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("Deepika");
        driver.findElement(By.name("email")).sendKeys("deepikadeepu@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("deepikadeepu");
        driver.findElement(By.id("exampleCheck1")).click();
       
        WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(1);
        driver.findElement(By.id("inlineRadio2")).click();
        driver.findElement(By.name("bday")).sendKeys("01/27/2000");
        driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
        System.out.println(driver.findElement(By.cssSelector("div[class*='alert-success']")).getText());
        
	}

}
