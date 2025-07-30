package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumPractice {
	
	public static void main(String[] args) {
		
		//WebDriver driver=new ChromeDriver();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println("Title of web page is:"+title);
		driver.quit();
	}

}
