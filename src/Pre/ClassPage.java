package Pre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClassPage {
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
	
	@Test(dependsOnMethods="login")
	public void ClassListing() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("div.mdl-layout__drawer-button")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//span[text()='Live Classes']")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//div[@class='floatingBtn']")).click();
		WebElement elm=driver.findElement(By.id("creationOverlay"));
		driver.switchTo().frame(elm);
		driver.findElement(By.id("txtTitle")).sendKeys("Class creation");
		
		driver.findElement(By.linkText("Set current date and time")).click();
		
		driver.findElement(By.id("rdpublic")).click();
		
		//driver.findElement(By.linkText("Add more information about your class")).click();
		driver.findElement(By.id("btnSchedule")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//button[contains(@class,'noShadow')]")).click();
		driver.switchTo().defaultContent();
	}

	
}
