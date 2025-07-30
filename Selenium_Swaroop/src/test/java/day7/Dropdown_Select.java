package day7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_Select {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		WebElement day=driver.findElement(By.id("day"));
		WebElement month=driver.findElement(By.id("month"));
		WebElement year=driver.findElement(By.id("year"));
		Select se=new Select(day);
		//here in case of select class only parameterized constructor is available..
		//so we need to pass element parameter in the constructor
		Select se1=new Select(month);
		Select se2=new Select(year);
		se.selectByIndex(11);
		se1.selectByVisibleText("Apr");
		se2.selectByValue("2000");
		
		//Retrieve all the options from the select dd and print - 2 ways
		//1. for this we can use Select dd object and getOptions method
		
		List<WebElement> days =se.getOptions();
		System.out.println("Total WebElements in the dd:"+days.size());
		
		//Using advanced for loop
//		for(WebElement a:days)
//		{
//			System.out.println(a.getText());
//			System.out.println();
//		}
//		
		//Using normal for loop
//		
//		for(int i=0;i<days.size();i++)
//		{
//			System.out.println(days.get(i).getText());
//		}
		
		
		
		//2.Using common attribute in all values and findelements method
		List<WebElement> ds=driver.findElements(By.xpath("//select[@id='day']/option"));
		System.out.println("Total elements:"+ds.size());
		
		//Using advanced for loop
//		for(WebElement a:ds)
//		{
//			System.out.println(a.getText());
//			System.out.println();
//		}
		
		//Using normal for loop
		
		for(int i=0;i<days.size();i++)
		{
			System.out.println(days.get(i).getText());
		}
		
		
		//// To get existing/already selected by default dd values,
		//we need to use getFirstSelectedOption() method, using select class object
		
		se.getFirstSelectedOption();
		

	}

}
