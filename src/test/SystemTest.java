package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SystemTest{
	@Test
	 public void f() {
		 System.setProperty("webdriver.chrome.driver","/home/gaben/eclipse-workspace/prac/chromedriver");
		 WebDriver driver = new ChromeDriver();
		driver.get("localhost:8080/bank");
		Assert.assertEquals( driver.getTitle(), "Bank");
		driver.quit();
	 }
 }