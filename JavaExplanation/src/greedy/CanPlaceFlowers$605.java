package greedy;

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
         * @SpaceComplexity O(1)
         * @Since 2021-02-18
         * @TimeOver    99.98%
         * @SpaceOver   5.05%
         */
        public boolean canPlaceFlowers(int[] flowerbed, int n){
            int count = 0;
            int m = flowerbed.length;
            int prev = -1;
            for (int i = 0; i < m; i++) {
                if (flowerbed[i] == 1) {
                    if (prev < 0) {
                        count += i / 2;//[0,i-1]之间都为0，这里最多可以种多少朵花
                    } else {
                        count += (i - prev - 2) / 2;//在[prev+1,i-1]之间都为0，这里最多可以种植的花数
                    }
                    prev = i;//改变区间左端点
                }
            }
            if (prev < 0) {
                count += (m + 1) / 2;//整个区间都为0，最多可以种的花
            } else {
                count += (m - prev - 1) / 2;//整个区间不为零，在[prev+1,m-1]之间为0，这里最多可以种花……
            }
            return count >= n;
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
