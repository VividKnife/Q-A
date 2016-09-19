

public class SJF {
	
	public static void main(String[] args)
	{
		int[] request = new int[]{0,1,3,9};
		int[] duration = new int[]{2,1,7,5};
		
		System.out.println(WaitAverage1(request,duration));
		
	}
	
	private static double WaitAverage1(int[] request, int[] duration)
	{
		if(request == null || duration == null || request.length == 0 || duration.length == 0)
			return 0;
		int length = request.length;
		int[] end = new int[length];
		int currentTime = 0;
		
		for(int i = 0; i < length;i++)
		{
			if(i==0)
			{
				currentTime = duration[0];
				end[0] = duration[0];
			}else
			{
				int minDuration = Integer.MAX_VALUE;
				int currentProcess = 0;
				for(int j = 0; j<length;j++)
				{
					if(end[j]!=0) continue;
					if(request[j]<=currentTime)
					{
						if(duration[j]<minDuration)
						{
							minDuration = duration[j];
							currentProcess = j;
						}
					}else
					{
						break;
					}
				}
				if(currentProcess == 0)
				{
					currentProcess = i;
					currentTime = request[currentProcess];
				}
				currentTime += duration[currentProcess];
				end[currentProcess] = currentTime;
			}
		}
		int waitsum = 0;
		for(int i = 0; i< length; i++)
		{
			waitsum += end[i]-request[i]-duration[i];
		}
		return (double)waitsum/(double)length;
	}

}
