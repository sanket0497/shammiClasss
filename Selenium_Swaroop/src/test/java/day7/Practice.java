package day7;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class Practice {
	public static void main(String[] args) {
		
		int a[] = { 1, 2, 3, 2, 3, 2, 2, 5, 6, 7, 6 };
		
		HashSet hs=new HashSet();
		
		for(int i=0;i<a.length;i++)
		{
			hs.add(a[i]);
		}
		System.out.println(hs);
	}

}
