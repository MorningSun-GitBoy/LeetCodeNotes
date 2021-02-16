package enumeration;

import Utils.ArrayInputUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SummeryRanges$228 {
    private static class Solution {
        /**
         * give you a int array,you should return a minimum order ranges which can cover all elements
         * @param nums 0 <= nums.length <= 20 , -2^31 <= nums[i] <= 2^31 - 1
         * @return List String List to store String range
         * @TimeComplexity O(n)
         * @SpaceComplexity O(1)
         * @Since 2021-02-16
         * @TimeOver    100.00%
         * @SpaceOver   48.76%
         */
        public List<String> summaryRanges(int[] nums) {
            List<String> ret = new ArrayList<String>();
            int i = 0;
            int n = nums.length;
            while (i < n) {
                int low = i;
                i++;
                while (i < n && nums[i] == nums[i - 1] + 1) {
                    i++;
                }
                int high = i - 1;
                StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
                if (low < high) {
                    temp.append("->");
                    temp.append(Integer.toString(nums[high]));
                }
                ret.add(temp.toString());
            }
            return ret;
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
