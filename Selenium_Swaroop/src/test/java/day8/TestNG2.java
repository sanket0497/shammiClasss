package day8;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG2 {

	@Test(enabled=false)
	public void a1() {
		System.out.println("a1");
	}

    @Test(dependsOnMethods= {"a1"})
	public void b1() {
		System.out.println("b1");
	}

	@Test()
	public void c1() {
		System.out.println("c1");
		throw new SkipException("skipping c1 test method");
	}

	

}
