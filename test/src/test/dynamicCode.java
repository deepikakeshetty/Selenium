package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dynamicCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepika.keshetty\\Desktop\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();
        String selectedOption = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
        WebElement staticdropdown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(staticdropdown);
        dropdown.selectByVisibleText(selectedOption);
        driver.findElement(By.id("name")).sendKeys(selectedOption);
        driver.findElement(By.id("alertbtn")).click();
        String text = driver.switchTo().alert().getText();
        if(text.contains(selectedOption)) {
        	System.out.println("Text grabbed succesfully");
        }
	}

}
