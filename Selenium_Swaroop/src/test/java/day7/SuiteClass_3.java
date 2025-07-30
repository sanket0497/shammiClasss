package day7;

import org.testng.annotations.Test;

public class SuiteClass_3 {
@Test(priority=2)
	
	public void tc2()
	{
		System.out.println("i am having priority 2");
	}
	
@Test(priority=5)
	
	public void tc5()
	{
		System.out.println("i am having priority 5");
	}


}
