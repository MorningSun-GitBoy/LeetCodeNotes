package enumeration;

import Utils.ArrayInputUtils;
import Utils.ArrayOutputUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SquaresOfASortesArr$977 {
    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\Enumeration\\SquaresOfASortesArr_977_Input"));
        boolean isRight;
        while(sc.hasNext()){
            String inputStr = sc.nextLine();
            int[] inputArr = ArrayInputUtils.stringTransToArray(inputStr);
            int[] res = s.sortedSquares(inputArr);
            isRight = false;
            for(int i=1;i<res.length;i++){
                if(res[i-1]<res[i]) {
                    isRight = true;
                    break;
                }
            }
            System.out.print(isRight);
            System.out.print("------");
            System.out.println("输入："+ inputStr +"\t输出："+ArrayOutputUtils.integerArrayOut(res));
        }
    }
    private static class Solution {
        public int[] sortedSquares(int[] nums) {
            int i=0,j=0;
            for(i=0;i<nums.length;i++){
                nums[i] = nums[i] * nums[i];
            }
            for(i=0;i<nums.length;i++){
                for(j=1;j<nums.length;j++){
                    if(nums[j-1] > nums[j]){
                        nums[j-1] += nums[j];
                        nums[j] = nums[j-1] - nums[j];
                        nums[j-1] = nums[j-1] - nums[j];
                    }
                }
            }
            return nums;
        }
    }
}
