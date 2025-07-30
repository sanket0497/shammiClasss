package day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		Actions ac = new Actions(driver);
		
		WebElement mins=driver.findElement(By.xpath("//div[@name='rangeInput']//span[1]"));
		WebElement maxs=driver.findElement(By.xpath("//div[@name='rangeInput']//span[2]"));
		Thread.sleep(2000);
		ac.dragAndDropBy(maxs,-200,0).perform();
	}

}
