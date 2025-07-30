package day7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Multiselect_dd {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// locating dd
		WebElement cd = driver.findElement(By.id("colors"));
		Select se = new Select(cd);
		se.selectByIndex(0); // Red
		se.selectByValue("blue");
		se.selectByVisibleText("White");

		// deselect all values (also we can deselect value based on
		// index,value,visibletext
		// se.deselectAll();

		// To get all selected options from dd, we can use getAllSelectedOptions(),(this
		// method will only work with Select class)
		// and to retrieve all the options from the dd, we can use getOptions() method
		List<WebElement> ao = se.getAllSelectedOptions();
		System.out.println(ao.size()); // returns size(total number of selected elements)

		// printing all options
		for (WebElement op : ao) {
			System.out.println(op.getText());

		}
		// also we have getFirstSelectedOption() method, to select first option
		// we can check whether dd is multiselected or not using 'isMultiple()' method
		// -- so as a first check we can do this using
		// if condition i.e if dropdown is multiselected then only proceed like that

		// driver.close();

	}

}
