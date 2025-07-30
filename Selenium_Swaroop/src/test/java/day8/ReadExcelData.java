package day8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws Exception {

		// specify the location of excel file

		File file = new File("C:\\Users\\sanket\\OneDrive\\Desktop\\Testing_All\\SELENIUM\\DDT_Practice.xlsx");

		// Load the file

		FileInputStream fis = new FileInputStream(file);

		// Load the workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Load Worksheeet

		XSSFSheet sh = wb.getSheet("Data");

		// print total number of rows - 2 ways

		// way 1 - this will return all active rows..basically rows which contains data
		int rows1 = sh.getPhysicalNumberOfRows();
		System.out.println("Total Number Of Rows:" + rows1);

		// way 2- this will return last index, (which will be total active rows -1)

		int rows2 = sh.getLastRowNum();
		System.out.println(rows2 + 1);

		// print total number of cells - 2 ways

		// way 1
		int col1 = sh.getRow(0).getPhysicalNumberOfCells();
		System.out.println("colums:" + col1);

		// way 2
		int col2 = sh.getRow(0).getLastCellNum();
		System.out.println(col2);

		// fetch specific data
		// In excel rows and columns index starts from zero

		String sname = sh.getRow(4).getCell(2).getStringCellValue(); // pawar
		System.out.println(sname);

		// fetching int value (//usually when we fetch any numeric data from excel sheet
		// by default it will fetch as float for. Ex value 123 will be printed as
		// 123.0..
		// so to avaoid this , while priniting just typecast it (int) in code….
		// (By default getNumericcellValue method will fetch value in float format))
		DataFormatter formatter = new DataFormatter();
		String v1 = formatter.formatCellValue(sh.getRow(4).getCell(4));
		System.out.println(v1);
		
		//Fetch all data
		
		for(int i=0;i<=rows1;i++)
		{
			for(int j=0;j<=col1;j++)
			{
				DataFormatter format = new DataFormatter();
				String value = format.formatCellValue(sh.getRow(i).getCell(j));
				//String value=sh.getRow(i).getCell(j).toString();
				System.out.print(value+ " ");
			}
			System.out.println();
		}

	}

}
