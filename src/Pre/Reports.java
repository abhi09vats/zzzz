package Pre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Reports {
	
	WebDriver driver;
	@Test
	public void login() throws InterruptedException {
		 
		String driverpath = System.getProperty("user.dir") + "\\src\\Browser\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://admin2016.ng.pre.wiziqinternal.com/authentication/login");
		driver.findElement(By.id("email")).sendKeys("test2016@mailinator.net");
		driver.findElement(By.id("password")).sendKeys("111111111111111");
		driver.findElement(By.xpath("//button[contains(@class,'filledStylePri')]")).click();
		Thread.sleep(3000);
	}
	@Test
	public void report() throws InterruptedException {
		Thread.sleep(15000);
		driver.findElement(By.cssSelector("div.mdl-layout__drawer-button")).click();
		//driver.findElement(By.xpath("//span[@class='listCol']")).click(); library
		Thread.sleep(25000);
		driver.findElement(By.xpath("//span[text()='Reports']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Classes']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='LEARNERS']")).click();
		
	}

}
