package day7;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions2 {

	// do control click on webinars option

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://academy.swaroopnadella.com/");
		Actions ac = new Actions(driver);
		WebElement webinar = driver.findElement(By.linkText("Webinars"));
		ac.moveToElement(webinar).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
		System.out.println(driver.getWindowHandle());
		Set<String>ws=driver.getWindowHandles();
		Iterator it=ws.iterator();
		String parent=(String) it.next();
		String child=(String) it.next();
		System.out.println(parent+" "+child);
		Thread.sleep(2000);
		driver.switchTo().window(child);
		System.out.println(driver.getWindowHandle());

	}

}
