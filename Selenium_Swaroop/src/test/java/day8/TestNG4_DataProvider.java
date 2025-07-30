package day8;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG4_DataProvider {
	WebDriver driver;

	@DataProvider
	public Object[][] testdata() {
		Object arr[][] = new Object[2][2];
		arr[0][0] = "abc@gmail.com";
		arr[0][1] = "pass@123";

		arr[1][0] = "def@gmail.com";
		arr[1][1] = "pass@456";

		return arr;
	}

	@BeforeClass
	public void setenv() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test(dataProvider = "testdata")
	public void Login(String username, String password) throws Exception {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("pass")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		
	}

}
