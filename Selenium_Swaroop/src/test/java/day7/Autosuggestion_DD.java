package day7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestion_DD {

	public static void main(String[] args) {
	   
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		//will search any text, so will get related things automatically
		driver.findElement(By.xpath("//textarea[@role='combobox']")).sendKeys("Selenium java");
		
		//now will locate all the suggested elements with the common locator(custom xpath)
		//also we need to use things that won't change in future by any update..means constant values
		List<WebElement> all_op=driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@role='option']"));
		System.out.println("Total number of suggested values:"+all_op.size());
		
		//now will print all those values using enhanced for loop
		
//		for(WebElement ops:all_op)
//		{
//			System.out.println(ops.getText());
//		}
		
		//to click on the specific element
		//1st way - normal by inspecting that webelement
		//driver.findElement(By.xpath("//ul[@role='listbox']/li//div[@role='option']//span/b[text()=' tutorial']")).click();
		
		//2nd way.. by giving the text in for loop itself(actual text)
		

		for(WebElement ops:all_op)
		{
			if(ops.getText().equals("selenium java programs for interview"))
			{
				ops.click();
				break;
				// here we are breaking the loop, so it won't check for all values, once given value is match it will
				//break the loop
			}
			
			  
		}
		

	}

}
