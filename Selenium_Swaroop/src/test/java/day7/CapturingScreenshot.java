package day7;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapturingScreenshot {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://academy.swaroopnadella.com/");

		// 1. Full page screenshot
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File src=ts.getScreenshotAs(OutputType.FILE);
//		File tgt=new File("./swaroop/"+"swaroophome.png");
//		FileUtils.copyFile(src, tgt);

//		// 2.Specific Section of page -- locate that specific section using custom
//		// locator
//		// which will highlight multiple webelements/ some section of webpage
//		WebElement section=driver.findElement(By.xpath("//div[@class='column full']"));
//		File src = section.getScreenshotAs(OutputType.FILE);
//		File tgt = new File("./swaroop/" + "swaroophome1.png");
//		FileUtils.copyFile(src, tgt);

		// 3.Specific webelement of page -- locate that specific section using specific
		// locator
		// which will highlight single webelement of the webpage
		WebElement section = driver.findElement(By.linkText("Login"));
		File src = section.getScreenshotAs(OutputType.FILE);
		File tgt = new File("./swaroop/" + "Login.png");
		FileUtils.copyFile(src, tgt);

	}

}
