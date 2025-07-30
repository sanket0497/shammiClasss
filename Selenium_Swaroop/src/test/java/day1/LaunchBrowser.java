package day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://kite.zerodha.com/?next=%2Fmargins%E2%80%9D");
		driver.manage().window().maximize();
		
		FileInputStream fi=new FileInputStream("C:\\Users\\sanket\\OneDrive\\Desktop\\Testing_All\\SELENIUM\\DDT_Practice.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Data");
		String username=sh.getRow(1).getCell(0).getStringCellValue();
		String pwd= sh.getRow(1).getCell(1).getStringCellValue();
		
		driver.findElement(By.id("userid")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
	

	}

}
