package day7;

public class C2 extends Super_C{
	String name="cat";
	
	void m1()
	{
		super.m1();
		System.out.println("hello");
		System.out.println(super.name);
	}
	
	public static void main(String[] args) {
		C2 c=new C2();
		System.out.println(c.name);
		c.m1();
		
	}
	
	

	
	
	
}
