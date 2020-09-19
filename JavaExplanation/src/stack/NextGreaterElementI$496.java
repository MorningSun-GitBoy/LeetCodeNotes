package stack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @TimeComplexity  O(n)
 * @SpaceComplexity O(n)
 * @Since 2020-09-13
 * @TimeOver    99.17%
 * @SpaceOver   46.25%
 */
public class NextGreaterElementI$496 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("CaseFiles/Stack/NextGreaterElement_I_496_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles/Stack/NextGreaterElement_I_496_Output"));
        while(sc.hasNext()){
            String nums1Str = sc.nextLine();
            String nums2Str = sc.nextLine();
            String resNumsStr = so.nextLine();
            String strNums1[] = nums1Str.substring(1,nums1Str.length()-1).split(",");
            String strNums2[] = nums2Str.substring(1,nums2Str.length()-1).split(",");
            //System.out.println(strNums1[0]);
            //System.out.println(strNums1[1]);
            int[] nums1 = new int[strNums1.length];
            int[] nums2 = new int[strNums2.length];
            for(int i=0;i<nums1.length;i++){
                nums1[i] = new Integer(strNums1[i]).intValue();
            }
            for(int i=0;i<nums2.length;i++){
                nums2[i] = new Integer(strNums2[i]).intValue();
            }
            StringBuilder sb = new StringBuilder("[");
            int[] resNum = new Solution().nextGreaterElement(nums1,nums2);
            for(int i : resNum){
                sb.append(i);
                sb.append(",");
            }
            sb.replace(sb.length()-1,sb.length(),"]");
            //System.out.println(sb.toString());
            System.out.print(sb.toString().equals(resNumsStr));
            System.out.print("------------");
            System.out.print(nums1Str+"\t");
            System.out.print(nums2Str+"\t");
            System.out.println(sb);
        }
    }
    private static class Solution{
        public int[] nextGreaterElement(int[] nums1,int[] nums2){
            Stack<Integer> stack = new Stack<Integer>();
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            int[] res = new int[nums1.length];
            for(int i=0;i<nums2.length;i++){
                while(!stack.isEmpty() && nums2[i] > stack.peek())
                    map.put(stack.pop(),nums2[i]);//
                stack.push(nums2[i]);
            }
            while(!stack.isEmpty())
                map.put(stack.pop(),-1);
            for(int i=0;i<nums1.length;i++){
                res[i] = map.get(nums1[i]);
            }
            return res;
        }
    }
}
