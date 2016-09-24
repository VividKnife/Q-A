import java.util.*;
public class MostNumb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3,4,4,5,5,5,6};
		System.out.println(mostNumb(nums));

	}
	public static Integer mostNumb(int[] nums)
	{
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		Integer max = 0;
		Integer mostNumber = nums[0];
		for(int i = 0; i < nums.length; i++)
		{
			Integer num = nums[i];
			Integer oldcount = map.get(num);
			
			if(oldcount!=null)
			{
				map.replace(num, oldcount+=1);
				if(max<oldcount+1)
				{
					max = oldcount+1;
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
