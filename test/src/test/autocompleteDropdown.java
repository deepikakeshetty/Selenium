package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class autocompleteDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepika.keshetty\\Desktop\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        //Thread.sleep(2000);
        WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(2));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-menu-item-wrapper")));
        int count =driver.findElements(By.className("ui-menu-item-wrapper")).size();
        List<WebElement> options=driver.findElements(By.className("ui-menu-item-wrapper"));
        for(int i=0;i<count;i++) {
        	if(options.get(i).getText().equalsIgnoreCase("India")) {
        		options.get(i).click();
        		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
        		break;
        		
        	}
        }
        /*List<WebElement> options=driver.findElements(By.className("ui-menu-item-wrapper"));
        for(WebElement option : options) {
        	if(option.getText().equalsIgnoreCase("India")) {
        		option.click();
        		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
        		break;
        	}
        }*/
	}

}
