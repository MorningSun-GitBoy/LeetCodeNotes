package enumeration;

import Utils.ArrayInputUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumOddLengthSubarrays$1588 {
    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\Enumeration\\SumOddLengthSubarrays_1588_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles\\Enumeration\\SumOddLengthSubarrays_1588_Output"));
        while(sc.hasNext()){
            String inputStr = sc.nextLine();
            int output = Integer.valueOf(so.nextLine());
            int res = s.sumOddLengthSubarrays(ArrayInputUtils.stringTransToArray(inputStr));
            System.out.print(res == output);
            System.out.println("------输入："+inputStr+"\t输出："+res);
        }
    }
    private static class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            //test
            //int num = 0;
            int sum = 0;
            for(int i=1;i<=arr.length;i=i+2){
                for(int j=0;j<arr.length-i+1;j++){
                    for(int k=j;k<j+i&&k<arr.length;k++){
                        sum += arr[k];
                        //num ++;
                    }
                }
            }
            //System.out.println(num);
            return sum;
        }
    }
}
