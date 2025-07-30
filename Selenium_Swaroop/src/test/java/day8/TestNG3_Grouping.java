package day8;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNG3_Grouping {

	@Test(groups = "sanity")
	public void a1() {
		System.out.println("a1");
	}

	@Test(groups = "sanity")
	public void b1() {
		System.out.println("b1");
	}

	@Test(groups = { "sanity", "regression" })
	public void c1() {
		System.out.println("c1");

	}
	
	@Test(groups = "regression")
	public void d1() {
		System.out.println("d1");

	}
}
