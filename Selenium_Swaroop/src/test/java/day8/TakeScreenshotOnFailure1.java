package day8;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TakeScreenshotOnFailure1 {
	WebDriver driver;

	@Test
	public void captureScreenshot(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus())
//as we know if block will always execute if the condition is true, so in the above scenario 
//if the test case failed then only the if block will be executed
//here...... It is checking "Did the test fail?"

//ITestResult.FAILURE means test failed.

//result.getStatus() tells us the actual result of the test.

//The == checks if both are the same.			
		{
			// take actaul ss of failed tc
			// create reference of TakeScreenshot interface
			TakesScreenshot ts = (TakesScreenshot) driver;
			// above we are typecasting since we are assigning one interface reference into
			// another
			// interface reference (TakesScreenshot and WebDriver both are interfaces)

			// Use getScreenshotAs() method to capture the screenshotin the file fomat
			File src = ts.getScreenshotAs(OutputType.FILE);

			// copy the file to a specific location
			File tgt = new File("./screenshots/" + result.getName() + ".png");
			// above "./screenshots/" - it will create screenshots folder under project
			// workspace
			// itself, . indicates project location and in that location we are creating
			// screenshots folder (/screenshots)
			// result.getName() - using result reference we are fetching name of failed test
			// case and adding extension as .png, so under screenshots folder will see
			// failed test
			// case screenshot with that test case name

			FileUtils.copyFile(src, tgt);
			System.out.println(result.getName() + " method() failed, screenshot captured");

		}

	}

}
