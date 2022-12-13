package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepika.keshetty\\Desktop\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.qaclickacademy.com/");
        driver.findElement(By.xpath("//nav[@class='navbar-collapse collapse']/ul/li[5]")).click();
        //driver.findElement(By.cssSelector("nav[class*='navbar-collapse'] ul li:nth-child(5)")).click();
        
        System.out.println(driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).size());
        System.out.println(driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th")).size());
        
        int count = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr[3]/td")).size();
        List<WebElement> secondRow=driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr[3]/td"));
        for(int i=0;i<count;i++) {
        	System.out.println(secondRow.get(i).getText());
        }

	}

}
