package day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		Actions ac = new Actions(driver);

		// scenario:
		/*
		 * In text area 1 will pass one string then selct that text then copy that text
		 * then then paste it in text area 2
		 */
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("sanket");

		// keydown - to press the key
		// keyUp - to release the key

		// select all (press control+A)
		ac.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform(); // Ctrl+A;

		// copy - control + c
		ac.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

		// paste it in textarea 2 - so first move to text area 2 by , clicking TAB key
		ac.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		ac.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		ac.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL);

	}

}
