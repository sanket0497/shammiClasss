package day7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// 1.Find total number of rows in a table (rows - 'tr' tag)

		int rnum = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr")).size();
		System.out.println("Total number of rows in a table:" + rnum);

		// 2.Find total number of columns in a table (tag under 'tr' ..heading(first
		// row) -th..other columns - td(table data)..we can use any of them)
		int cnum = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[1]/th")).size();
		System.out.println("Total number of columns in a table:" + cnum);

		// Retrieve data for specific row and specific column (ex. here will fetch daya
		// from 2nd row and 3rd column- "Selenium' value)
		String v1 = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[2]/td[3]")).getText();
		System.out.println(v1);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		// 3.Retrieve all the data from the webtable -- need to use loop here
		// print headers

		for (int j = 1; j <= cnum; j++) // row 1 -header..th tag..but in expression we have given td tag..row fix -
										// 1st..onlty column we are incrementing till 4 to get all headers
		{

			String hvalues = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[1]/th[" + j + "]"))
					.getText();
			// (here we did concatination to give variable name (i&j))
			System.out.print(hvalues + " ");

		}
		System.out.println();

		// 4.print data

		for (int i = 2; i <= rnum; i++) // row 1 -header..th tag..but in expression we have given td tag
		{
			for (int j = 1; j <= cnum; j++) {
				String values = driver
						.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[" + i + "]/td[" + j + "]"))
						.getText();
				// (here we did concatination to give variable name (i&j))
				System.out.print(values + "   "); // to print in table format
			}
			System.out.println();

		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		// 5.want to fetch book return by particular author(here we want to fetch books
		// return by amit)
		// author 2nd column..so column fix we need to iterate through all rows and when
		// there id amit value
		// need to fetch corresponding book name
		System.out.println("Books written by amit are");

		for (int i = 2; i <= rnum; i++) // row 1 -header..th tag..but in expression we have given td tag
		{

			WebElement values = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[" + i + "]/td[2]"));
			// (here we did concatination to give variable name (i&j))

			if (values.getText().equalsIgnoreCase("Amit")) {
				String book = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[" + i + "]/td[1]"))
						.getText();
				System.out.println(book);
			}
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		// 6. Want to get price of all books(sum)
		// again price column position is fix, need to iterate through rows

		System.out.println("Total price of all the books is below");

		int total_price = 0;

		for (int i = 2; i <= rnum; i++) // row 1 -header..th tag..but in expression we have given td tag
		{

			String price = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[" + i + "]/td[4]"))
					.getText().toString();
			// String to int
			int pr = Integer.parseInt(price);
			total_price = total_price + pr;
		}
		System.out.println("Total Price:" + total_price);

		driver.close();

	}

}
