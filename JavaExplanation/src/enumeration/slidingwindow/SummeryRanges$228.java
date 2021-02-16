package enumeration.slidingwindow;

import Utils.ArrayInputUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SummeryRanges$228 {
    private static class Solution{
        /**
         * give you a int array,you should return a minimum order ranges which can cover all elements
         * @param nums 0 <= nums.length <= 20 , -2^31 <= nums[i] <= 2^31 - 1
         * @return List String List to store String range
         * @TimeComplexity O(n)
         * @SpaceComplexity O(1)
         * @Since 2021-02-16
         * @TimeOver    58.26%
         * @SpaceOver   28.06%
         */
        public List<String> summaryRanges(int[] nums){
            int i = 0,j = 1;
            List<String> res = new ArrayList<String>();
            if(nums.length==0) return res;
            while(j<nums.length){
                if(nums[j-1]+1 == nums[j])  j++;
                else{
                    if(j-1 == i)
                        res.add(String.valueOf(nums[i]));
                    else
                        res.add(nums[i]+"->"+nums[j-1]);
                    i = j;
                    j++;
                }

            }
            if(j-1 == i)
                res.add(String.valueOf(nums[i]));
            else    res.add(nums[i]+"->"+nums[j-1]);
            return res;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = "CaseFiles\\Enumeration\\SummeryRanges_228_Input";
        String outputFile = "CaseFiles\\Enumeration\\SummeryRanges_228_Output";
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream(inputFile));
        Scanner so = new Scanner(new FileInputStream(outputFile));
        while(sc.hasNext()){
            String inputStr = sc.nextLine();
            String outputStr = so.nextLine();
            List<String> res = s.summaryRanges(ArrayInputUtils.stringTransToArray(inputStr));
            System.out.print(outputStr.equals(res.toString()));
            System.out.println("------输入："+inputStr+"\t输出："+res);
        }
    }
}
