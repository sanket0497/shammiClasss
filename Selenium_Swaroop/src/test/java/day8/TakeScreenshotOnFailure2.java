package day8;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TakeScreenshotOnFailure2 {
	TakeScreenshotOnFailure1 t1 = new TakeScreenshotOnFailure1();

	@Test
	public void login1() {
		t1.driver = new ChromeDriver(); // we have already defined WebDriver globally
		// in TakeScreenshotOnFailure1 class, so using that
		t1.driver.manage().window().maximize();
		t1.driver.get("https://www.facebook.com/");
		t1.driver.findElement(By.id("sanket")).sendKeys("asagsg@gmail.com");
		// above intentionally we are passing wrong locator, so it will fail the test
		// case
	}

	@AfterMethod
	public void takesscreenshot(ITestResult result2) throws IOException // passing reference
	{
		t1.captureScreenshot(result2);
	}

}
