package dynamicprograming;

import Utils.ArrayInputUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CanPlaceFlowers$605 {
    private static class Solution{
        /**
         * give you a array filled with 0 and 1,if it rules there must be a 0 between two 1,could i
         * insert n 1 in this array
         * @param flowerbed the array filled with 0 and 1 1 <= flowerbed.length <= 2 * 10^4 flowerbed is under the rule
         * @param n want to insert how many 1 0 <= n <= flowerbed.length
         * @return can or not
         * @TimeComplexity O(n)
         * @SpaceComplexity O(n)
         * @Since 2021-02-18
         * @TimeOver    99.98%
         * @SpaceOver   88.49%
         */
        public boolean canPlaceFlowers(int[] flowerbed, int n){
            if (n == 0)return true;
            int len = flowerbed.length;
            if (len == 1)return flowerbed[0] == 0;// 此时n>=1,数组长度为1没有空位
            if (len == 2) {
                if (n > 1)return false;
                else return flowerbed[0] == 0 && flowerbed[1] == 0;
            }
            // 长度至少为3
            int[] dp = new int[len];
            dp[0] = (flowerbed[0] == 0 ? 1 : 0);
            if (flowerbed[0] == 0 && flowerbed[1] == 0)dp[1] = 1;
            else dp[1] = 0;
            for (int i = 2; i < len - 1; i++) {
                if (flowerbed[i] == 1 || flowerbed[i + 1] == 1 || flowerbed[i - 1] == 1)dp[i] = dp[i - 1];
                else {
                    dp[i] = Math.max(dp[i - 2] + 1, dp[i - 1]);
                }
            }
            // 最后一个位置特殊判断
            if (flowerbed[len - 1] == 1 || flowerbed[len - 2] == 1)dp[len - 1] = dp[len - 2];
            else dp[len - 1] = Math.max(dp[len - 3] + 1, dp[len - 2]);
            return dp[len - 1] >= n;// 可容纳花朵数>= n即true
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = "CaseFiles\\Dynamic-Programing\\CanPlaceFlowers_605_Input";
        String outputFile = "CaseFiles\\Dynamic-Programing\\CanPlaceFlowers_605_Output";
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream(inputFile));
        Scanner so = new Scanner(new FileInputStream(outputFile));
        while(sc.hasNext()){
            String inputStr = sc.nextLine();
            int n = Integer.valueOf(sc.nextLine());
            boolean outputBool = Boolean.valueOf(so.nextLine());
            boolean res = s.canPlaceFlowers(ArrayInputUtils.stringTransToArray(inputStr),n);
            System.out.print(res == outputBool);
            System.out.println("------输入："+inputStr+"\t"+n+"\t输出："+res);
        }
    }
}
