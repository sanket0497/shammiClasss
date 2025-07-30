package day7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hidden_dd {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		//Passing credentials to login
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[contains(@class,'oxd')]")).click();
		
		//Navigate to PIM section
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		
		//Locating Hidden dd and click on it (need to build custom xpath, as we don't have specific unique identifier)
		 WebElement hdd=driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div/div"));
		 hdd.click();
		 
		 //meanwhile in webpage by using setTimer() method, we should inspect required webelement
		 //first will capture all the elements in that hidden dd
		 
		 //use custom xpath which can locate all the elements in the dd (common xpath/locator)
		 
		List<WebElement> jd= driver.findElements(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div/div/div/following-sibling::div[@role='listbox']/div[@role='option']/span"));
		System.out.println("Total available values under job title dropdown are:"+jd.size());
		
		//select all values from dd
		
		for(WebElement jd_all:jd)
		{
			System.out.println(jd_all.getText());
		}
		 
		 //select any value from dd
		 //driver.findElement(By.xpath("//span[text()='QA Engineer']")).click();
		// driver.findElement(By.xpath("//span[text()='QA Lead']")).click();
		 //same logic will work for all types of hidden dd
		

	}

}
