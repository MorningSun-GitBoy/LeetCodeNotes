package enumeration.majorityvote;

import Utils.ArrayInputUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
            int len = nums.length;
            int cnt = 0, major = Integer.MIN_VALUE;
            //cnt : 投票计数， major : 主要元素
            for(int n : nums){
                if(cnt == 0){
                    major = n;
                    cnt ++;
                }
                else{
                    if(major == n) cnt ++;
                    else cnt --;
                }
            }
            int C = 0;
            for(int i = 0; i < len; i++) {
                if(nums[i] == major) C++;
            }
            if(C <= len / 2) major = -1;
            return major;
        }
    }
}
