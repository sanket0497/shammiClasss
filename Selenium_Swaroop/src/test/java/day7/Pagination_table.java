package day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination_table {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		driver.manage().window().maximize();

		// fetch total number of pages
		String txt = driver.findElement(By.xpath("//div[contains(text(),'entries')]")).getText();
		System.out.println(txt); // Showing 11 to 20 of 57 entries
		System.out.println();
		System.out.println();

		// now will fetch number of entries(here 57), that value is dynamic, so we need
		// to write locator in such way
		// will use substring() method, but instead of hardcoding wil write customized
		// xpath so in future if no.of entries
		// gets changed, still it should fetch the value(no. of entries)
		// starting index will be after 'f' letter and ending before 'e' letter

		String total_entries = txt.substring((txt.indexOf("f") + 1), (txt.indexOf("e") - 1));
		System.out.println("Total number of entries in the table are:" + total_entries);
		System.out.println();
		System.out.println();

		// we can convert this String value to integer using wrapper class
		// int t_entries=Integer.parseInt(total_entries);

		// now will make the customized xpath which will highlight all the page numbers,
		// so we can click on every page()except first
		// page ,as it will be by default on the first page)

		// take total row numbers of the table

		// take total columns numbers of the table
		int cnum = driver.findElements(By.xpath("//table[@class='display dataTable']//tbody//tr[1]/td")).size();
		System.out.println("Total number of columns in the table are:" + cnum);
		System.out.println();
		System.out.println();

		// looping through the pages and print the data

		// print headers

		for (int i = 1; i <= 6; i++) {
			String headers = driver.findElement(By.xpath("//table[@class='display dataTable']//tr[1]/th[" + i + "]"))
					.getText();
			System.out.print(headers + " ");
		}
		System.out.println();
		// print data

		for (int i = 1; i <= 6; i++) // since total 6 pages are there
		{
			// page no. one is by default loading, so we need to write condition as if page
			// number is greater than 1,
			// then only click on it

			if (i > 1) {
				driver.findElement(By.xpath("//button[contains(text()," + i + ")]")).click();
			}

			int rnum = driver.findElements(By.xpath("//table[@class='display dataTable']//tbody//tr")).size();
			System.out.println("Total number of rows in the table are:" + rnum);
			System.out.println();
			System.out.println();

			// print the data
//			System.out.println("Data on the page number "+i+" is as below:");
//			//suppose we have to fetch customer name,it's in 1st column so column no. is fixed ,
			// we need to iterate through all rows
			System.out.println("Below are the customer names on page number " + i + ":");
			for (int r = 2; r <= rnum; r++) // rows
			{

				String cname = driver
						.findElement(By.xpath("//table[@class='display dataTable']//tbody//tr[" + r + "]/td[1]"))
						.getText();
				String position = driver
						.findElement(By.xpath("//table[@class='display dataTable']//tbody//tr[" + r + "]/td[2]"))
						.getText();
				System.out.println(cname + "  ::  " + position);
			}
			// same logic will be applicable for all columns, if we want to fetch value for
			// any other column just change constant
			// column number, iteration of rows as it is

		}

		driver.close();

	}

}
