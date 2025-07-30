package day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateVsGetMethod {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.selenium.dev/");
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().refresh();

	}

}
