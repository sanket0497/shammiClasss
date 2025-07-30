package day7;

import org.testng.annotations.Test;

public class SuiteClass_1 {
	@Test(priority=3)
	
	public void tc3()
	{
		System.out.println("i am having priority 3");
	}
	
@Test(priority=6)
	
	public void tc6()
	{
		System.out.println("i am having priority 6");
	}

}
