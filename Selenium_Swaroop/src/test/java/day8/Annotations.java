package day8;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@Test
	public void a1()
	{
		System.out.println("test");
	}
	
	@AfterSuite
	public void b1()
	{
		System.out.println("aftersuite");
	}
	
	@BeforeMethod
	public void c1()
	{
		System.out.println("beforemethod");
	}
	
	@AfterClass
	public void d1()
	{
		System.out.println("afterclass");
	}
	
@BeforeSuite
	public void e1()
	{
		System.out.println("beforesuite");
	}
	
	@BeforeTest
	public void f1()
	{
		System.out.println("beforetest");
	}
	
	@AfterMethod
	public void g1()
	{
		System.out.println("aftermethod");
	}
	
	@AfterTest
	public void h1()
	{
		System.out.println("aftertest");
	}
	
	@AfterSuite
	public void j1()
	{
		System.out.println("aftersuite");
	}
	
	public static void main(String[] args) {
		
		System.out.println("main");
	}
	@BeforeClass
	public void k1()
	{
		System.out.println("beforeclass");
	}
	

}
