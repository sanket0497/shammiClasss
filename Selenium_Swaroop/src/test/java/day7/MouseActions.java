package day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		// WebElement men=driver.findElement(By.linkText("Cart"));
		Actions ac = new Actions(driver);

		// create an action using build() method
		Action act = ac.doubleClick().build(); // stored action in Action interface

		// execute an action using perform() method

		act.perform();

	}

}
