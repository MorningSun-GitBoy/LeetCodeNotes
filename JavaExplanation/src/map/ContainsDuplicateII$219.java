package map;

import Utils.ArrayInputUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContainsDuplicateII$219 {
    private static class Solution{
        /**
         * make sure that there are or not two equaling element in nums with their distance not longer than k
         * @param nums
         * @param k     1<=k<=nums.length
         * @return      true---exist false---no exist
         * @TimeComplexity O(n)
         * @SpaceComplexity O(n)
         * @Since 2021-02-12
         * @TimeOver    59.46%
         * @SpaceOver   70.78%
         */
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; ++i) {
                //表中是否存在
                if (set.contains(nums[i])) return true;
                //将新的元素填入表
                set.add(nums[i]);
                //表的长度是否超过k
                if (set.size() > k) {
                    //除去最先放进的元素，维护表的长度
                    set.remove(nums[i - k]);
                }
            }
            return false;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = "CaseFiles\\Map\\ContainsDuplicateII_219_Input";
        String outputFile = "CaseFiles\\Map\\ContainsDuplicateII_219_Output";
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream(inputFile));
        Scanner so = new Scanner(new FileInputStream(outputFile));
        while(sc.hasNext()){
            String inputStr = sc.nextLine();
            int k = Integer.valueOf(sc.nextLine());
            boolean outputBool = Boolean.valueOf(so.nextLine());
            boolean res = s.containsNearbyDuplicate(ArrayInputUtils.stringTransToArray(inputStr),k);
            System.out.print(res == outputBool);
            System.out.println("------输入："+inputStr+"\t"+k+"\t输出："+res);
        }
    }
}
