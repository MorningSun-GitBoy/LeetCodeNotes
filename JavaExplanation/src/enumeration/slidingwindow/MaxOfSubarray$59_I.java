package enumeration.slidingwindow;

import Utils.ArrayInputUtils;
import Utils.ArrayOutputUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxOfSubarray$59_I {
    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\Enumeration\\MaxOfSubarray_59_I_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles\\Enumeration\\MaxOfSubarray_59_I_Output"));
        while(sc.hasNext()){
            String inputStr = sc.nextLine();
            String outputStr = so.nextLine();
            int k = Integer.valueOf(sc.nextLine());
            int[] res = s.maxSlidingWindow(ArrayInputUtils.stringTransToArray(inputStr),k);
            String resStr = ArrayOutputUtils.integerArrayOut(res);
            System.out.print(resStr.equals(outputStr));
            System.out.println("------输入："+inputStr+"\t输出："+resStr);
        }
    }
    private static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int i = 0;
            int j = 0;
            List<Integer> maxList = new ArrayList<Integer>();
            int thisMax = Integer.MIN_VALUE;
            while(j<nums.length){
                if(nums[j]>thisMax)
                    thisMax = nums[j];
                if(j-i+1 == k){
                    maxList.add(thisMax);
                    if(nums[i] == thisMax){
                        j = i;
                        thisMax = Integer.MIN_VALUE;
                    }
                    i++;
                }
                j++;
            }
            i = 0;
            int[] res = new int[maxList.size()];
            for(Integer a : maxList){
                res[i++] = a;
            }
            return res;
        }
    }
}
