package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepika.keshetty\\Desktop\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(By.id("datepicker")));
        //Thread.sleep(5000);
        driver.findElement(By.id("datepicker")).click();
        
        while(!driver.findElement(By.cssSelector("[id='ui-datepicker-div'] [class*='ui-datepicker-header']")).getText().contains("January")) {
        	driver.findElement(By.cssSelector("span[class='ui-icon ui-icon-circle-triangle-e']")).click();
        }
        
        List<WebElement> dates = driver.findElements(By.className("ui-state-default"));
        int count = driver.findElements(By.className("ui-state-default")).size();
        for(int i=0;i<count;i++) {
        	String date = driver.findElements(By.className("ui-state-default")).get(i).getText();
        	if(date.equalsIgnoreCase("27")) {
        		dates.get(i).click();
        		break;
        	}
        }
        System.out.println(driver.findElement(By.id("datepicker")).getAttribute("value"));
       
	}

}
