package day7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DD_Bootstrap {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		// click on bootstrap dd
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();

		// now select one option from dd(By clicking on that option)(here will click on
		// java)
		driver.findElement(By.xpath("//input[contains(@value,'Java')]")).click();

		// to get/fetch all the values from bootstrap dd, we need to build customized
		// xpath,which can
		// highlight all the elements from dd

		List<WebElement> opts = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//label"));
		System.out.println("Total elements:" + opts.size());

		for (WebElement op : opts) {
			System.out.println(op.getText());

			// click on specific option
			if (op.getText().equalsIgnoreCase("Python")) {
				op.click();
			}
		}

	}

}
