import java.util.*;
public class MostNumb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3,4,4,5,5,5,6};
		System.out.println(mostNumb(nums));

	}
	// find the most number in a array list
	//using hashmap, complexity O(n), space O(n)
	public static Integer mostNumb(int[] nums)
	{
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		Integer maxcount = 0;
		Integer mostNumber = nums[0];
		for(int i = 0; i < nums.length; i++)
		{
			Integer num = nums[i];
			Integer curcount = map.get(num);
			
			if(curcount!=null)
			{
				map.replace(num, curcount+=1);//if same number appears counter it up
				
				if(maxcount<curcount+1) // if maxcount is less than current counter replace it
				{
					maxcount = curcount+1;
					mostNumber = num;
				}
			}else
			{
				map.put(num, 1);
			}
		}
		return mostNumber;
		
	}

}
