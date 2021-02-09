package enumeration.presum;

import Utils.ArrayInputUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumOprationToReduceXToZero$1658 {
    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\Enumeration\\MinimumOprationToReduceXToZero_1658_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles\\Enumeration\\MinimumOprationToReduceXToZero_1658_Output"));
        while(sc.hasNext()){
            String inputNums = sc.nextLine();
            String inputX = sc.nextLine();
            int output = so.nextInt();
            so.nextLine();
            int[] nums = ArrayInputUtils.stringTransToArray(inputNums);
            int x = Integer.valueOf(inputX);
            int res = s.minOperations(nums,x);
            System.out.print(res == output);
            System.out.println("------输入："+inputNums+"\t"+inputX+"\t输出："+res);
        }
    }
    private static class Solution {
        public int minOperations(int[] nums, int x) {
            /**
             * left presum 前n项和
             * right presum 前n项和
             * x = left[i] + right[j]
             * return i+j
             */
            int len = nums.length;
            int res = Integer.MAX_VALUE;
            int[] left = new int[len+1];
            int[] right = new int[len+1];
            for(int i=0;i<len;i++){
                left[i+1] = left[i] + nums[i];
                right[i+1] = right[i] +nums[len-i-1];
            }
            int i = 0,j = len;
            while(i<len && j>0){
                if(left[i] + right[j] == x){
                    res = Math.min(res,i+j);
                    j--;
                }else if(left[i] + right[j] > x)
                    j--;
                else i++;
            }
            return res > len ? -1 : res;
        }
    }
}
