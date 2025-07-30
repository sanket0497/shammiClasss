package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@placeholder='Username' AND @type='text']")).sendKeys("standard_user");
		String txt=driver.findElement(By.xpath("//h4[text()='Accepted usernames are:']")).getText();
		System.out.println(txt);
		

	}

}
