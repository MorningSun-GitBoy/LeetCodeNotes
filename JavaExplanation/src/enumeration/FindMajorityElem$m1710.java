package enumeration;

import Utils.ArrayInputUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindMajorityElem$m1710 {
    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\Enumeration\\FindMajorityElem_m1710_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles\\Enumeration\\FindMajorityElem_m1710_Output"));
        while(sc.hasNext()){
            String inputStr = sc.nextLine();
            String output = so.nextLine();
            int[] inputArr = ArrayInputUtils.stringTransToArray(inputStr);
            String res = String.valueOf(s.majorityElement(inputArr));
            System.out.print(res.equals(output));
            System.out.print("------");
            System.out.println("输入："+inputStr+"\t输出："+res);
        }
    }
    private static class Solution{
        public int majorityElement(int[] nums) {
            Set<Integer> numSet = new HashSet<Integer>();
            int[][] table = null;
            int index = 0,max = 0;
            for(int i=0;i<nums.length;i++){
                numSet.add(nums[i]);
            }
            table = new int[numSet.size()][2];
            int i=0;
            for(int a : numSet){
                table[i++][0] = a;
            }
            for(i=0;i<table.length;i++){
                for(int j=0;j<nums.length;j++){
                    if(table[i][0] == nums[j])
                        table[i][1]++;
                }
            }
            /**
             * 测试数组
             */
             /*for(i=0;i<table.length;i++){
                 System.out.print(table[i][0]);
                 System.out.print("\t");
                 System.out.println(table[i][1]);
             }*/
            for(i=0;i<table.length;i++){
                if(max<table[i][1]){
                    max = table[i][1];
                    index = i;
                }
            }
            //System.out.println(nums.length);
            return table[index][1]>nums.length/2?table[index][0]:-1;
        }
    }
}
