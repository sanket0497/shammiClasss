package day7;

import org.testng.annotations.Test;

public class SuiteClass_2 {
	
@Test(priority=1)
	
	public void tc1()
	{
		System.out.println("i am having priority 1");
	}
	
@Test(priority=4)
	
	public void tc4()
	{
		System.out.println("i am having priority 4");
	}

}
