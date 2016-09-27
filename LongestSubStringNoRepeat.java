import java.util.*;
import java.lang.*;
public class LongestSubStringNoRepeat {

	
	public static void main(String[] args)
	{
		String s = "123512345671qwisnhfpmz123456789qwertyuiopasdfghjklzxcvbnm";
		System.out.println(lsr(s));
	}
	
	public static int lsr(String s)
	{
		if(s == null || s.length()==0) return 0;
		StringBuilder sb = new StringBuilder();
		int result = 0;
		for(char x : s.toCharArray())
		{
			int i = sb.toString().indexOf(x);
			
			System.out.println("sb: "+sb);
			System.out.println("x: " +x);
			System.out.println("i: " + i);
			
			if(i<0) sb.append(x);
			else
			{
				int len = sb.length();
				if(result<len) result = len;
				sb.delete(0, i+1);
				sb.append(x);
				System.out.println(result);
			}
			System.out.println("--------------");
		}
		int len = sb.length();
		if(result<len) result = len;
		
		return result;
	}
}
