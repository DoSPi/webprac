package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class SystemTest{
	private WebDriver driver;
	@BeforeTest
	public void begin() {
		System.setProperty("webdriver.chrome.driver","/home/gaben/eclipse-workspace/prac/chromedriver");
		driver = new ChromeDriver();
	}
	@AfterTest
	public void end() {
		driver.quit();
	}
	@Test(priority = 1)
	 public void AddAccount() {
		driver.get("localhost:8080/bank/");
		Assert.assertEquals( driver.getTitle(), "Bank");
		driver.findElement(By.linkText("Accounts")).click();
        Assert.assertEquals(driver.getTitle(),"Accounts");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[3]/td[1]")).getText(), "1");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[3]/td[3]")).getText(), "Central");
        driver.findElement(By.linkText("Add Account")).click();
        Assert.assertEquals(driver.getTitle(),"Edit Account");
        driver.findElement(By.id("client.client_id")).sendKeys("1");
        driver.findElement(By.id("type.type_id")).sendKeys("1");
        driver.findElement(By.id("payment_account.account_id")).sendKeys("2");
        driver.findElement(By.id("department.department_id")).sendKeys("2");
        driver.findElement(By.id("add")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//tr[6]/td[1]")).getText(), "4");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[6]/td[2]")).getText(), "ez profit");
	 }
	@Test(priority = 2)
	 public void AddAccountEx() {
		driver.get("localhost:8080/bank/");
		Assert.assertEquals( driver.getTitle(), "Bank");
		driver.findElement(By.linkText("Accounts")).click();
		Assert.assertEquals(driver.getTitle(),"Accounts");
		driver.findElement(By.linkText("Add Account")).click();
		Assert.assertEquals(driver.getTitle(),"Edit Account");
		driver.findElement(By.id("client.client_id")).sendKeys("9999");
		driver.findElement(By.id("type.type_id")).sendKeys("1");
		driver.findElement(By.id("payment_account.account_id")).sendKeys("2");
		driver.findElement(By.id("department.department_id")).sendKeys("2");
		driver.findElement(By.id("add")).click();
       Assert.assertEquals(driver.getTitle(),"Error");
	 }
	@Test(priority = 3)
	 public void CloseAccount() {
		driver.get("localhost:8080/bank/");
		Assert.assertEquals( driver.getTitle(), "Bank");
		driver.findElement(By.linkText("Accounts")).click();
       Assert.assertEquals(driver.getTitle(),"Accounts");
       Assert.assertEquals(driver.findElement(By.xpath("//tr[3]/td[8]")).getText(), "false");
       driver.findElement(By.xpath("//tr[3]/td[8]")).click();
       Assert.assertEquals(driver.findElement(By.xpath("//tr[6]/td[8]")).getText(), "true");
	 }
	@Test(priority = 4)
	public void AddClient(){
		driver.get("localhost:8080/bank/");
		Assert.assertEquals( driver.getTitle(), "Bank");
		driver.findElement(By.linkText("Clients")).click();
		Assert.assertEquals(driver.getTitle(),"Clients");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[3]/td[1]")).getText(), "1");
		Assert.assertEquals(driver.findElement(By.xpath("//tr[3]/td[2]")).getText(), "Ivan ivanov");
		driver.findElement(By.linkText("Add Client")).click();
		Assert.assertEquals(driver.getTitle(),"Edit Client");
		driver.findElement(By.id("name")).sendKeys("Keka");
		driver.findElement(By.id("address")).sendKeys("Beka");
		driver.findElement(By.id("email")).sendKeys("testmail@mail.com");
		driver.findElement(By.id("phone_number")).sendKeys("89262901412");
		driver.findElement(By.id("add_a")).click();
	 }
 }