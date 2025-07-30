package day2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowsers {

	public static void main(String[] args) {
	
		//Chrome
//		ChromeDriver cd=new ChromeDriver();
//		cd.get("https://www.selenium.dev/");
//		cd.manage().window().maximize();
//		cd.close();
		
		//edge
//		EdgeDriver ed=new EdgeDriver();
//		ed.get("https://www.selenium.dev/");
//		ed.manage().window().maximize();
//		ed.close();
//		
		//FireFoxDriver
		FirefoxDriver fd= new FirefoxDriver();
		fd.get("https://www.selenium.dev/");
		fd.manage().window().maximize();
		fd.close();

	}

}
