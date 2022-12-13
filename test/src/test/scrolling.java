package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class scrolling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepika.keshetty\\Desktop\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 600)");
        //component scroll
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
        
        //highlighing the 4th column in the table
        int sum=0;
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        for(int i=0;i<values.size();i++) {
        	sum = sum+Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);
        driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
        //Total Amount Collected: 296
        int num=Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
        if(sum==num) {
        	System.out.println("success");
        }
       
       

	}

}
