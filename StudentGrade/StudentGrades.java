import java.util.*;
public class StudentGrades {
/*
 * 
 * 
 * 
 * 
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Grade> input = new ArrayList<Grade>();
		input.add(new Grade(1,100));
		input.add(new Grade(1,100));
		input.add(new Grade(1,100));
		input.add(new Grade(1,100));
		input.add(new Grade(1,100));
		input.add(new Grade(1,10));
		input.add(new Grade(1,20));
		input.add(new Grade(2,20));
		input.add(new Grade(2,20));
		
		List<Grade> output = averageGrade(input);
		System.out.println(output.get(0).studentID);
		System.out.println(output.get(0).studentGrade);
		System.out.println(output.get(1).studentID);
		System.out.println(output.get(1).studentGrade);
		

	}
	public static List<Grade> averageGrade(List<Grade> input)
	{
		//corner check
		if(input.size() == 0||input == null)return null;
		if(input.size() == 1)return input;
		int len = input.size();
		//use this HashMap to store grades for all students
		HashMap<Integer,LinkedList<Integer>> IdWithGrades =new HashMap<Integer,LinkedList<Integer>>();
		for(int i = 0; i < len; i++)
		{
			Grade cur = input.get(i);
			if(IdWithGrades.containsKey(cur.studentID))//check if this student is already added to the hashmap
			{
				LinkedList<Integer> tmp = IdWithGrades.get(cur.studentID);
				if(cur.studentGrade>tmp.getLast())//if the new grade for this student is less than the last grade in the list, move on
				{
					if(tmp.size()==5)	tmp.removeLast();
					tmp.addLast(cur.studentGrade);
					sortLinkedList(tmp);
				}
			}
			else
			{
			LinkedList<Integer> grades = new LinkedList<Integer>();
			grades.add(cur.studentGrade);
			IdWithGrades.put(cur.studentID,grades);
			}
		}
		//The HashMap now contains every student with their best 5 grade
		Iterator<Map.Entry<Integer, LinkedList<Integer>>> iterator = IdWithGrades.entrySet().iterator();
		List<Grade> result = new ArrayList<Grade>();
		while(iterator.hasNext())//iterate every student
		{
			Map.Entry<Integer, LinkedList<Integer>> entry = iterator.next();
			Integer totalGrade=0;
			LinkedList<Integer> list = entry.getValue();
			//sum up the grades in the list
			for(int i = 0; i<list.size();i++)
			{
				totalGrade += list.get(i);
			}
			Integer g = totalGrade/list.size();
			Integer id = entry.getKey();
			//store the best 5 average and this student's id to the result list
			Grade gradeSet = new Grade(id, g);
			result.add(gradeSet);
		}
		return result;
	}
	
	public static void sortLinkedList(LinkedList<Integer> list)
	{
		//Since only one new element is added to this list and this list pre sorted, just need to insert this new element
		Integer lastNumber = list.removeLast();
		if(lastNumber<list.getLast()) return;
		if(lastNumber>list.getFirst()) {list.addFirst(lastNumber); return;}
		for(int i=list.size()-1;i>0;i--)
		{
			if(lastNumber>list.get(i))
			{
				list.add(i, lastNumber);
				break;
			}
		}
	}

}
