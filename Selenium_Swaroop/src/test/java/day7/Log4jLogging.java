package day7;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log4jLogging {

	public static void main(String[] args) {
		// create logger instance

		Logger lg = Logger.getLogger("Log4jLogging");

		// configure log4j.properties file using PropertyConfigurator class
		// will copy same file shared by shammi and paste it in our repository folder
		// where
		// other properties files are present

		PropertyConfigurator.configure("D:\\Java_Projects_Workspace\\Selenium_Swaroop\\repository\\log4j.properties");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		lg.info("web page launched");

		driver.manage().window().maximize();
		lg.info("browser maximized");

	}

}
