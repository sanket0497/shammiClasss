package day7;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Relative_Locators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().scriptTimeout(null);
		driver.get("https://ui.vision/demo/webtest/frames/"); 
	
		
		//switch to frame 3
		WebElement f3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(f3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Sanket");
		
		//now switch to child frame of frame 3
		
		driver.findElement(By.tagName("iframe"));
		driver.findElement(By.xpath("//*[@id=\"i9\"]/div[3]/div")).click();
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Pawar");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		ChromeOptions op=new ChromeOptions();
		op.setPageLoadStrategy(PageLoadStrategy.EAGER);
		//WebDriver driver=new ChromeDriver(op);
		driver.get("https://ui.vision/demo/webtest/frames/"); 
	
		
		
	}
}