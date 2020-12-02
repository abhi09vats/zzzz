package Learner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;

	@Test
	public void login() throws InterruptedException {

		String driverpath = System.getProperty("user.dir") + "\\src\\Browser\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get("http://admin2016.ng.pre.wiziqinternal.com/authentication/login");
		driver.findElement(By.id("email")).sendKeys("learner40@yopmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[contains(@class,'filledStylePri')]")).click();
		
	}

	@Test(enabled = false)
	public void courseAttempt() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[text()='Course created by automation']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Start Learning']")).click();

	}

	@Test(dependsOnMethods = "login")
	public void catalog() throws InterruptedException {
		Thread.sleep(15000);
		driver.findElement(By.cssSelector("div.mdl-layout__drawer-button")).click();
		driver.findElement(By.xpath("//span[text()='Catalog']")).click();
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement elm = driver.findElement(By.linkText("people tab 2"));
		Thread.sleep(10000);
		js.executeScript("arguments[0].scrollIntoView();", elm);
		elm.click();
	}

}
