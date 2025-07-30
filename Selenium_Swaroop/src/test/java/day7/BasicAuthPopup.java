package day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthPopup {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		String exp_text = "Congratulations! You must have the proper credentials.";
		String act_text = driver
				.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]"))
				.getText();

		if (exp_text.equals(act_text)) {
			System.out.println("user has logged in with proper authentication");
		}
		driver.close();
}

}
