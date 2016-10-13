/**
 * Created by shufan on 2016/10/12.
 */
public class LongestAbsoluteFilePath {

    
//    public class Solution {
//        int globalIndex=0;
//        String input;
//        public int lengthLongestPath(String input)
//        {
//            this.input = input;
//            globalIndex = 0;
//            Stack<int[]> pathStack = new LinkedList<int[]>();
//            int maxLength = 0;
//
//
//            String dir = getNextName();
//            if(isFile(dir)) return dir.length();
//            pathStack.push(new int[]{dir.length(),0});
//            while(hasNext())
//            {
//                int level = getNextLevel();
//                String file = getNextName();
//                updateStack(pathStack, level, file);
//                if(isFile(file)) maxLength = Math.max(maxLength, pathStack.pop()[0]);
//            }
//            return maxLength;
//        }
//        private boolean isFile(String name)
//        {
//            int i = name.indexOf('.');
//            if(i>0 && name.length()>(i+1)) return true;
//            else return false;
//        }
//
//        private int getNextLevel()
//        {
//            if(input.charAt(globalIndex)!='\') return -1;
//            if(input.charAt(globalIndex) != 'n') return 0;
//            int level = 1;
//            for(;;globalIndex++)
//            {
//
//                if(input.charAt(globalIndex) == 't')
//                {
//                    level++;
//                    if(input.charAt(globalIndex+1) != '\') break;
//                }
//            }
//            return level;
//        }
//
//        private String getNextName()
//        {
//            int endIndex = input.indexOf('\',globalIndex);
//            if(endIndex > globalIndex){
//                String name = input.substring(globalIndex,endIndex);
//                globalIndex = endIndex;
//                return name;
//            }else{
//                String name = input.substring(globalIndex);
//                globalIndex = input.length()-1;
//                return name;
//            }
//        }
//
//        private boolean hasNext()
//        {
//            return globalIndex<input.length();
//        }
//
//        private void updateStack(Stack<int[]> stack, int level, String file)
//        {
//            while(stack.peek()[1] <= level)
//            {
//                stack.pop();
//            }
//            int length = stack.peek()[0] + file.length();
//            int[] pair = new int[]{length,level};
//            stack.push(pair);
//        }
//
//    }
}
