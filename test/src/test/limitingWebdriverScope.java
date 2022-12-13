package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class limitingWebdriverScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepika.keshetty\\Desktop\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        //count of links on the page
        driver.getTitle();
        System.out.println(driver.findElements(By.tagName("a")).size());
        
       //limiting the webdriver scope
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerdriver.findElements(By.tagName("a")).size());
        
        //get the count of a column links in footer
        WebElement columndriver =footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columndriver.findElements(By.tagName("a")).size());
        
        //clicking on each link in the column and checking whether it is openings pages or not
        for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++) {
        	String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);        	
        	columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
        	
        }
        Set<String> getTitle= driver.getWindowHandles();
    	Iterator<String> it=getTitle.iterator();
    	while(it.hasNext()) {
    		driver.switchTo().window(it.next());
    		System.out.println(driver.getTitle());
    	}

	}

}
