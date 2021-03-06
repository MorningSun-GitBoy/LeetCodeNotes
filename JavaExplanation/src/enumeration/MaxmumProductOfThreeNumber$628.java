package enumeration;

import Utils.ArrayInputUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxmumProductOfThreeNumber$628 {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = "CaseFiles\\Enumeration\\MaxmumProductOfThreeNumber_628_Input";
        String outputFile = "CaseFiles\\Enumeration\\MaxmumProductOfThreeNumber_628_Output";
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream(inputFile));
        Scanner so = new Scanner(new FileInputStream(outputFile));
        while(sc.hasNext()){
            String inputStr = sc.nextLine();
            int outputInt = Integer.valueOf(so.nextLine());
            int res = s.maximumProduct(ArrayInputUtils.stringTransToArray(inputStr));
            System.out.print(res == outputInt);
            System.out.println("------输入："+inputStr+"\t输出："+res);
        }
    }
    private static class Solution {
        /**
         *  choose three element from one array , make the product of them biggest
         * @param  nums  -1000<=nums[i]<=1000  3<=nums.length<=1000
         * @return the maxmum product of three elements
         * @TimeComplexity O(n)
         * @SpaceComplexity O(1)
         * @Since 2021-02-11
         * @TimeOver    82.94%
         * @SpaceOver   91.48%
         */
        public int maximumProduct(int[] nums) {
            int     min_1 = Integer.MAX_VALUE,
                    min_2 = Integer.MAX_VALUE;
            int     max_1 = Integer.MIN_VALUE,
                    max_2 = Integer.MIN_VALUE,
                    max_3 = Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                if(min_1 > nums[i]){
                    min_2 = min_1;
                    min_1 = nums[i];
                }else if(min_2 > nums[i]){
                    min_2 = nums[i];
                }
                if(max_1 < nums[i]){
                    max_3 = max_2;
                    max_2 = max_1;
                    max_1 = nums[i];
                }else if(max_2 < nums[i]){
                    max_3 = max_2;
                    max_2 = nums[i];
                }else if(max_3 < nums[i]){
                    max_3 = nums[i];
                }
            }
            return Math.max(min_1*min_2*max_1,max_1*max_2*max_3);
        }
    }
}
