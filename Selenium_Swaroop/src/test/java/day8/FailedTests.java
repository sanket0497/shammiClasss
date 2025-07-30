package day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedTests {

	
	
		@Test(enabled=false)
		public void a1() {
			System.out.println("a1");
		}

		@Test
		public void b1() {
			Assert.assertTrue(3>12);
			System.out.println("b1");
		}

		@Test
		public void c1() {
			System.out.println("c1");

		}
		
		@Test
		public void d1() {
			System.out.println("d1");

		

	}

}
