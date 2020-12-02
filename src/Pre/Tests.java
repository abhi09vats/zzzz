package Pre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tests {
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
	public void tests() throws InterruptedException {
		Thread.sleep(15000);
		driver.findElement(By.cssSelector("div.mdl-layout__drawer-button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Tests']")).click();
	}

	@Test(dependsOnMethods = "tests")
	public void TestCreation() throws InterruptedException {
		Thread.sleep(15000);
		driver.findElement(By.xpath("//div[@class='floatingBtn']")).click();
		Thread.sleep(10000);
		WebElement elm = driver.findElement(By.id("creationOverlay"));
		driver.switchTo().frame(elm);
		driver.findElement(By.id("input")).sendKeys("test creation by automation");
		driver.findElement(By.id("Label31")).click();
		Thread.sleep(20000);
		driver.findElement(By.id("addQuestion")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='MCQ Standard']")).click();
		Thread.sleep(20000);
		driver.findElement(By.cssSelector("div.lrn-qe-form-group")).click();
		System.out.println("done");
		driver.findElement(By.xpath("//*[@id=\"questionpopup\"]/div[1]/div/div[1]/div/div[3]/div[2]/div/div/div[2]/div[1]/div/div/div/div/p")).clear();
		driver.findElement(By.xpath("//*[@id=\"questionpopup\"]/div[1]/div/div[1]/div/div[3]/div[2]/div/div/div[2]/div[1]/div/div/div/div/p")).sendKeys("test creation");
		//driver.findElement(By.xpath("div[text()='Choice 1']")).clear();
		driver.findElement(By.xpath("//span[text()='B']")).click();
		driver.findElement(By.id("SaveQuestione")).click();
		//*[@id="qe_391_draggable_container_512"]/div[2]/div/div[1]/div/div[1]/div/div/text()
		
		
	}

}
