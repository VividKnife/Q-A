import java.lang.Math;
/**
 *
 * Created by shufan on 16/10/1
 *
 *
 *Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
 For Example:
 ab: Number of insertions required is 1. bab or aba
 aa: Number of insertions required is 0. aa
 abcd: Number of insertions required is 3. dcbabcd

 Input:

 The first line of input contains an integer T denoting the number of test cases.
 The first line of each test case is S.

 Output:

 Print the minimum number of characters.
 */
public class FormPalindrome {

    public static void main(String[] args)
    {
        String test = "qwerr";
        System.out.println(findMinRecursive(test));
        System.out.println(findMinDP(test));
    }

    public static int findMinRecursive(String input)
    {
        if(input.length()==0) return 0;
        return recursiveHelper(input,0,input.length()-1);
    }

    public static int recursiveHelper(String input, int first, int last)
    {
        if(first > last) return Integer.MAX_VALUE;
        if(first == last) return 0;
        if(first == last -1) return input.charAt(first) == input.charAt(last)? 0: 1;

        return  input.charAt(first) == input.charAt(last)?
                recursiveHelper(input,first+1,last-1)
                :Math.min(  recursiveHelper(input,first+1,last),
                            recursiveHelper(input,first,last-1))+1;

    }

    public static int findMinDP(String input)
    {
        int len = input.length();
        if(len<2) return 0;
        int[][] dptable = new int[len][len]; //A diagonal fashion table from 01,12,23,...

        for(int gap=1;gap<len;gap++) // gap here can be treat as window size.
        {
            for(int l = 0, h = gap;h<len;h++,l++)
            {
                dptable[l][h] =  input.charAt(l) == input.charAt(h)?
                    dptable[l+1][h-1]
                    :Math.min(  dptable[l+1][h],
                                dptable[l][h-1])+1;

            }
        }
        return dptable[0][len-1];

    }

}
