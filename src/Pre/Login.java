package Pre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
	

	@Test
	public void login() throws InterruptedException {
		WebDriver driver;
		String driverpath = System.getProperty("user.dir") + "\\src\\Browser\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get("http://admin2016.ng.pre.wiziqinternal.com/authentication/login");
		driver.findElement(By.id("email")).sendKeys("test2016@mailinator.net");
		driver.findElement(By.id("password")).sendKeys("111111111111111");
		driver.findElement(By.xpath("//button[contains(@class,'filledStylePri')]")).click();
		Thread.sleep(15000);

	}
}
