package Pre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CourseCreeation {
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

	@Test(dependsOnMethods = "login")
	public void Schedule() throws InterruptedException {
		Thread.sleep(15000);
		driver.findElement(By.xpath("//div[@class='floatingBtn']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'material')]")).click();
		WebElement elm = driver.findElement(By.id("creationOverlay"));
		driver.switchTo().frame(elm);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@id='lbtnSaveSettings']")).click();
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//a[text()='30']")).click();
		driver.findElement(By.id("datepickerEnd")).click();
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.xpath("//a[text()='28']")).click();
		driver.findElement(By.id("txtTitle")).sendKeys("course schedule automated");
		driver.findElement(By.id("btnPublishCourse")).click();
		driver.findElement(By.id("btnPublishCourse")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("lbtnNextProfile")).click();
		driver.findElement(By.id("txtSubTitle")).sendKeys("11");
		driver.findElement(By.id("txtHighlight1")).sendKeys("1");
		driver.findElement(By.id("txtHighlight2")).sendKeys("11");
		driver.findElement(By.id("txtHighlight3")).sendKeys("11");
		WebElement elm2 = driver.findElement(By.id("txtAbtCourse_ifr"));
		driver.switchTo().frame(elm2);
		driver.findElement(By.id("tinymce")).sendKeys("1111");
		driver.switchTo().parentFrame();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//a[@id='lbtnNextInvite']")).click();
		// Set<Cookie> elm3 = driver.manage().getCookies();
		// System.out.println(elm3);
		// driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//button[contains(@class,'fluidModalClose')]")).click();
		driver.switchTo().defaultContent();
	}

	@Test(dependsOnMethods = "Schedule")

	public void Selfpaced() throws InterruptedException {
		Thread.sleep(20000);
		driver.findElement(By.xpath("//a[text()='school']")).click();
		WebElement elm = driver.findElement(By.id("creationOverlay"));
		driver.switchTo().frame(elm);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@id='lbtnSaveSettings']")).click();
		driver.findElement(By.id("txtTitle")).sendKeys("course selfpaced automated");
		driver.findElement(By.id("lbtnNextProfile")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("txtSubTitle")).sendKeys("11");
		driver.findElement(By.id("txtHighlight1")).sendKeys("1");
		driver.findElement(By.id("txtHighlight2")).sendKeys("11");
		driver.findElement(By.id("txtHighlight3")).sendKeys("11");
		WebElement elm2 = driver.findElement(By.id("txtAbtCourse_ifr"));
		driver.switchTo().frame(elm2);
		driver.findElement(By.id("tinymce")).sendKeys("1111");
		driver.switchTo().parentFrame();
		System.out.println("done");
		Thread.sleep(20000);
		driver.findElement(By.xpath("//a[@id='lbtnNextInvite']")).click();
		driver.switchTo().parentFrame();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//button[contains(@class,'fluidModalClose')]")).click();
		driver.switchTo().defaultContent();
		driver.navigate().refresh();

	}
	/*
	 * JavascriptExecutor js = (JavascriptExecutor) driver; WebElement elm =
	 * driver.findElement(By.linkText("course 11nov"));
	 * js.executeScript("arguments[0].scrollIntoView();", elm); elm.click();
	 */

}
