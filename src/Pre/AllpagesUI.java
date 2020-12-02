package Pre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllpagesUI {
	WebDriver driver;
	@BeforeTest
	public void BrowserLaunch() {
		String driverpath = System.getProperty("user.dir") + "\\src\\Browser\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void login() throws InterruptedException {
		
		driver.get("http://admin2016.ng.pre.wiziqinternal.com/authentication/login");
		driver.findElement(By.id("email")).sendKeys("test2016@mailinator.net");
		driver.findElement(By.id("password")).sendKeys("111111111111111");
		driver.findElement(By.xpath("//button[contains(@class,'filledStylePri')]")).click();
		Thread.sleep(3000);
	}
	@Test(dependsOnMethods="login")
	public void library() throws InterruptedException{
		Thread.sleep(15000);
		driver.findElement(By.cssSelector("div.mdl-layout__drawer-button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Library']")).click();
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods="library")
	public void tests() throws InterruptedException {
		Thread.sleep(15000);
		driver.findElement(By.cssSelector("div.mdl-layout__drawer-button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Tests']")).click();
	}
	@Test(dependsOnMethods="tests")
	public void ClassListing() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("div.mdl-layout__drawer-button")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//span[text()='Live Classes']")).click();
		
	}

	@Test(dependsOnMethods ="ClassListing")
	public void Usermangement() throws InterruptedException {
		Thread.sleep(15000);
		driver.findElement(By.cssSelector("div.mdl-layout__drawer-button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Academy Settings']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='General Settings']")).click();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='User Management']")).click();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Roles']")).click();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Transactions']")).click();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='API & Plugins']")).click();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Account Settings']")).click();
		Thread.sleep(5000);
		driver.navigate().back();
	}
	@Test(dependsOnMethods="Usermangement")
	public void report() throws InterruptedException {
		Thread.sleep(15000);
		driver.findElement(By.cssSelector("div.mdl-layout__drawer-button")).click();
		Thread.sleep(25000);
		driver.findElement(By.xpath("//span[text()='Reports']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Classes']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='LEARNERS']")).click();	
	}
	@Test(dependsOnMethods="report")
	public void PrivacyPolicy() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("div.mdl-layout__drawer-button")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//span[text()='Privacy Policy']")).click();
		 
	}
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
