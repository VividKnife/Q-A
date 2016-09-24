import java.util.*;
public class PhoneString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	


	
    public List<String> letterCombinations(String digits) {
    	String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    	LinkedList<String> ans = new LinkedList<String>();
    	ans.add("");
    	for(int i = 0; i < digits.length();i++)
    	{
    		int k = Character.getNumericValue(digits.charAt(i));
    		while(ans.peek().length()==i)
    		{
    			String pre = ans.removeFirst();
    			for(Character a : mapping[k].toCharArray())
    			{
    				ans.add(pre+a);
    			}
    		}
    	}
    	return ans;
    }
    
    /*
      public class Solution {
 String[][] refer={{},{},{"a","c","b"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
    
    public List<String> letterCombinations(String digits) {	        
    	List<String> list=new ArrayList<String>();
    	if(!digits.equals("")){helper(list,digits,""); return list;}
    	 return list;	    	
    }
    private void helper(List<String> list,String digits,String s){
    	   if(digits.length()==0){ list.add(s); return;}
    		int idx=Integer.parseInt(digits.substring(0, 1)); 
    		for(String k:refer[idx]){
    		  helper(list,digits.substring(1,digits.length()),s+k);	
    		}		
    	return;
    }
     */

}
