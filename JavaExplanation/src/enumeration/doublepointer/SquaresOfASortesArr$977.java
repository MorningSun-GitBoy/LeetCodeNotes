package enumeration.doublepointer;

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
            int[] inputArr = ArrayInputUtils.stringTransToArray(sc.nextLine());
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
            System.out.println("输入："+ ArrayOutputUtils.integerArrayOut(inputArr) +"\t输出："+ArrayOutputUtils.integerArrayOut(res));
        }
    }
    private static class Solution {
        public int[] sortedSquares(int[] nums) {
            int i=0,j=nums.length-1;
            int k = j;
            int[] res = new int[k+1];
            while(i<=j){
                if(Math.abs(nums[i])>Math.abs(nums[j])){
                    res[k--] = nums[i]*nums[i++];
                }else{
                    res[k--] = nums[j]*nums[j--];
                }
            }
            return res;
        }
    }
}
