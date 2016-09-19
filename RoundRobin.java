import java.util.LinkedList;
import java.util.Queue;
	// e.g.
	// arrival_time = [0, 1, 4], execution_time = [5, 2, 3], q = 3
	// average wait time = (7 - 5) + (5 - 3) + (10 - 7) / 3 = 2.3333333
	// q is quantum
public class RoundRobin {
	// 	SOL 1
		public static float waitingTimeRobin1(int[] arrival, int[] run,int q) {
			if (arrival == null || run == null || arrival.length !=
					run.length) {
				return 0;
			}
			Queue<Process> queue = new LinkedList<Process>();
			int curTime = 0;
			int waitTime = 0;
			int nextProIdx = 0;
			while (!queue.isEmpty() || nextProIdx < arrival.length) 
			{
				if (!queue.isEmpty()) {
					Process cur = queue.poll();
					waitTime += curTime - cur.arriveTime;

					curTime += Math.min(cur.excuteTime, q);

					for (int i = nextProIdx; i < arrival.length; i++)
					{
						if (arrival[i] <= curTime) {
							queue.offer(new Process(arrival[i],
									run[i]));
							nextProIdx = i + 1;
						} else {
							break;
						}
					}
					if (cur.excuteTime > q) {
						queue.offer(new Process(curTime,
								cur.excuteTime - q));
					}
				} else {
					queue.offer(new Process(arrival[nextProIdx],run[nextProIdx]));
					curTime = arrival[nextProIdx++];
				}
			}
			return (float)waitTime / arrival.length;
		}
		public static class Process {
			int arriveTime;
			int excuteTime;
			Process(int arr, int exc) {
				arriveTime = arr;
				excuteTime = exc;
			}
		}
		public static void main(String[] args) {
			int[] arrival1 = {0, 2, 40};
			int[] run1 = {5, 2, 3};
			int q1 = 5;
			int[] arrival2 = {0, 1, 3, 9};
			int[] run2 = {2, 1, 7, 5};
			int q2 = 3;
			System.out.print(waitingTimeRobin1(arrival1, run1, q1));
		}
}
	
	