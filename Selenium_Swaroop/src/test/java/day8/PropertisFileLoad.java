package day8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertisFileLoad {
	
	public static void main(String[] args) throws Exception {
		

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// specify the location of properties filee using File class (properties file 1)

		File f1 = new File("D:\\Java_Projects_Workspace\\Selenium_Swaroop\\repository\\config.properties");
		FileInputStream cp = new FileInputStream(f1);

		// create Properties class object to load and read the properties file
		Properties p1 = new Properties();
		p1.load(cp);

		// specify the location of properties filee using File class (properties file 2)

		File f2 = new File("D:\\Java_Projects_Workspace\\Selenium_Swaroop\\repository\\locators.properties");
		FileInputStream lp = new FileInputStream(f2);

		// create Properties class object to load and read the properties file
		Properties p2 = new Properties();
		p2.load(lp);

		// specify the location of properties filee using File class (properties file 3)

		File f3 = new File("D:\\Java_Projects_Workspace\\Selenium_Swaroop\\repository\\testdata.properties");
		FileInputStream tp = new FileInputStream(f3);

		// create Properties class object to load and read the properties file
		Properties p3 = new Properties();
		p3.load(tp);
		
		driver.get(p1.getProperty("URL"));
		driver.findElement(By.xpath(p2.getProperty("email"))).sendKeys(p3.getProperty("email"));
		driver.findElement(By.xpath(p2.getProperty("password"))).sendKeys(p3.getProperty("password"));
		driver.findElement(By.xpath(p2.getProperty("login"))).click();

	}

}
