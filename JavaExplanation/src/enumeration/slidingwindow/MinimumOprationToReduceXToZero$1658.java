package enumeration.slidingwindow;

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
             * sum - currentSum = x
             * length - windowLength = oprationNums
             */
            int maxPart = -1;
            int sum = Arrays.stream(nums).sum();
            int currentSum = 0;
            int left = 0;
            int right = 0;
            while (right < nums.length) {
                if (right < nums.length) {
                    currentSum += nums[right++];
                }
                while (currentSum > sum - x && left < nums.length) {
                    currentSum -= nums[left++];
                }
                if (currentSum == sum - x) {
                    maxPart = Math.max(maxPart, right - left);
                }
            }
            return maxPart == -1 ? -1 : nums.length - maxPart;
        }
    }
}
