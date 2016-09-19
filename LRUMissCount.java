import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUMissCount {
	static ArrayList<Integer> cache = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = new int[] {1,2,3,4,5,6,7,8,9,10,1,2,8,9,10};
		int i = LRUMissCt(a, 5);
		System.out.println(a.length);
		System.out.println(i);
		System.out.println(cache);
		
	}
	public static int LRUMissCt(int[] arr, int size) {
			if (arr == null || arr.length < 1) {
				return 0;
			}
		//	ArrayList<Integer> cache = new ArrayList<Integer>();
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if (cache.contains(arr[i])) {
					int tmp = arr[i];
					cache.remove(cache.indexOf(arr[i]));
					cache.add(tmp);
				} else {
					cache.add(arr[i]);
					cnt++;
				}
				if (cache.size() > size) {
					cache.remove(0);
					//cnt++;
				}
			}
			return cnt;
			
	}
	}
