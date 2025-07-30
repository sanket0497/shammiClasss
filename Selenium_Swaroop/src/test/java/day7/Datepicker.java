package day7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datepicker {
	// select month and year

	public static void selectMonthYear(WebDriver driver, String exp_month, String exp_year) {
		while (true) {
			String cu_month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText(); // current
																												// month
																												// common
																												// xpath
			String cu_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(); // current
																											// year
																											// common
																											// xpath

			if (cu_month.equals(exp_month) && cu_year.equals(exp_year)) {
				break; // once we get our expected month and year will break the loop
			}

			// otherwise will click on back button
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
		}

	}

	// select date

	public static void date(WebDriver driver, String exp_date) {
		List<WebElement> dates = driver.findElements(By.xpath("//a[@class='ui-state-default']"));

		for (WebElement dt : dates) {
			if (dt.getText().equals(exp_date)) {
				dt.click();
				break;
			}
		}
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		// Approach 1- typing the value in the textbox(directly sending the values)(when
		// it is allowed)

		// datepicker is inside the frame so 1st we need to switch to the frame

		WebElement fr = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(fr);
		// driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("05/12/2000");

		// Approach 2 -
		// datepicker textbox is enabling after clicked on it, so 1st will click on it
		// and then selection of date
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		String exp_month = "May";
		String exp_year = "2000";
		String exp_date = "12";

		// call method to select month and year
		selectMonthYear(driver, exp_month, exp_year);

		// now call method to select date
		date(driver, exp_date);

		// same logic for selection of future date only change is instead of clicking on
		// back button will click on forward button
		// same logic will work for most of the datepickers

	}

}
