package Pre;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Library {
	WebDriver driver;

	@Test
	public void login() throws InterruptedException {

		String driverpath = System.getProperty("user.dir") + "\\src\\Browser\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get("http://admin2016.ng.pre.wiziqinternal.com/authentication/login");
		driver.findElement(By.id("email")).sendKeys("test2016@mailinator.net");
		driver.findElement(By.id("password")).sendKeys("111111111111111");
		driver.findElement(By.xpath("//button[contains(@class,'filledStylePri')]")).click();
		Thread.sleep(3000);
	}

	@Test(dependsOnMethods = "login")
	public void library() throws InterruptedException {

		Thread.sleep(15000);
		driver.findElement(By.cssSelector("div.mdl-layout__drawer-button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Library']")).click();

		Thread.sleep(5000); // div[@class='fsp-modal']
		driver.findElement(By.xpath("//div[@class='floatingBtn']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='content']")).click();
		Thread.sleep(10000);

		/*
		 * File src = new File("C:\\Users\\for net.vats-pc\\Documents"); FileInputStream
		 * fis = new FileInputStream(src);
		 */

		driver.findElement(By.id("fsp-fileUpload"))
				.sendKeys("C:\\Users\\for net.vats-pc\\Documents\\CourseEnrollmentReport.xlsx");

		driver.findElement(By.xpath("//span[text()='Upload ']")).click();
		Thread.sleep(15000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement elm = driver.findElement(By.linkText("CourseEnrollmentReport"));
		js.executeScript("arguments[0].scrollIntoView();", elm);

	}

}
