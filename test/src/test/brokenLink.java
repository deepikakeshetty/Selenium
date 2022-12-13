package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class brokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepika.keshetty\\Desktop\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        
        //checking broken link for a single link
        //String url =driver.findElement(By.cssSelector("a[href*='restapi']")).getAttribute("href");
        
        
        //checking broken links for all the links
        
        //continuing checking the other broken links after reporting the failure
        List<WebElement> links =driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert s=new SoftAssert();
        for(WebElement link:links) {
        	String url=link.getAttribute("href");
        	HttpURLConnection con=(HttpURLConnection)new URL(url).openConnection();
            con.setRequestMethod("HEAD");
            con.connect();
            int respCode = con.getResponseCode();
            System.out.println(respCode);
            /*if(respCode>400) {
            	System.out.println("The link with Text "+link.getText()+" is broken with the code "+respCode);
            	Assert.assertTrue(false);
            }*/
            s.assertTrue(respCode<400, "The link with Text "+link.getText()+" is broken with the code "+respCode);
        }
        s.assertAll();
	}

}
