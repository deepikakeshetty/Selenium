package test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPagePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepika.keshetty\\Desktop\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        //String username = getUsername(driver);
        //String password = getPassword(driver);

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        WebElement staticdropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
        Select dropdown = new Select(staticdropdown);
        dropdown.selectByVisibleText("Student");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4[class='card-title']")));
        
        String[] itemsNeeded = {"iphone X","Samsung Note 8","Nokia Edge","Blackberry"};
        addToCart(driver,itemsNeeded);
        driver.findElement(By.partialLinkText("Checkout")).click();
        
       
	}

	public static void addToCart(WebDriver driver,String[] itemsNeeded) {
		// TODO Auto-generated method stub
		List<WebElement> items=driver.findElements(By.cssSelector("h4[class='card-title']"));
        int i,j=0;
        for(i=0;i<items.size();i++) {
        	j++;
        	List<String> itemsNeededList = Arrays.asList(itemsNeeded);
        	String name = items.get(i).getText();
        	String formattedName = name.trim();
        	if(itemsNeededList.contains(formattedName)){
        		driver.findElements(By.cssSelector("button[class*='btn-info']")).get(i).click();
        	}
        	if(j==itemsNeeded.length) {
        		break;
        	}
        }
	}
	
	/*public static String getUsername(WebDriver driver) {
		String text=driver.findElement(By.cssSelector("p[class*='text-white']")).getText();
		//(username is rahulshettyacademy and Password is learning)
		String[] arrayUsername1=text.split("and");
		String username=arrayUsername1[0].split("is")[1];
		return username;
	}
	public static String getPassword(WebDriver driver) {
		String text=driver.findElement(By.cssSelector("p[@class*='text-white']")).getText();
		//(username is rahulshettyacademy and Password is learning)
		String[] arrayPassword1=text.split("and");
		String password=arrayPassword1[1].split("is")[1];
		return password;
	}*/
}
