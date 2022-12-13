package test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepika.keshetty\\Desktop\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String[] productsNeeded = {"Brocolli","Carrot","Beans"};
        List<WebElement> products=driver.findElements(By.cssSelector("h4[class='product-name']"));
        
        int i,j=0;
        for(i=0;i<products.size();i++) {
        	String[] name = products.get(i).getText().split("-");
        	String formattedName = name[0].trim();
        	List<String> productsNeededList = Arrays.asList(productsNeeded);
        	if(productsNeededList.contains(formattedName)) {
        		j++;
        		driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
        		if(j==productsNeeded.length) {
        			break;
        		}
        	}
        	
        }
	}

}
