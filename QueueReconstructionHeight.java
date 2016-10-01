import java.util.*;

/**
 * Created by shufan on 16/10/1.
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k), where h
 * is the height of the person and k is the number of people in front of
 * this person who have a height greater than or equal to h.
 * Write an algorithm to reconstruct the queue.

 Note:
 The number of people is less than 1,100.

 Example

 Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionHeight {

    public static void main(String[] args)
    {
        int[][] test = new int[][]{ {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2} };
        for(int[] i : reconstructByHeight(test))
        {
            System.out.println(i[0]+","+i[1]);
        }
    }


    public static int[][] reconstructByHeight(int[][] people)
    {
        if(people.length < 2) return people;
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
            }
        });

        List<int[]> res = new LinkedList<>();

        for(int[] a : people)
        {
            res.add(a[1],a);
        }

        return res.toArray(new int[people.length][2]);

    }
}
