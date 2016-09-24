import java.util.*;

public class testHashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,LinkedList<Integer>> map = new HashMap<Integer,LinkedList<Integer>>();
		LinkedList<Integer> inputList = new LinkedList<Integer>();
		inputList.add(1);
		inputList.add(2);
		inputList.add(3);
		inputList.add(4);
		inputList.add(5);
		inputList.add(6);
		inputList.add(7);
		inputList.add(8);
		
		map.put(1, inputList);
		LinkedList<Integer> testList = map.get(1);
		testList.add(222);
		System.out.println(map.get(1));
		test(testList);
		System.out.println(testList);
		System.out.println(map.get(1));
		int a = 56;
		test2(a);
		System.out.println(a);
		Integer b = 66;
		test3(b);
		System.out.println(b);
		
	}
	public static void test(LinkedList<Integer> list)
	{
		list.removeFirst();
	}
	public static void test2(int a)
	{
		a = 3;
	}
	public static void test3(Integer a)
	{
		a=1;
	}

}
