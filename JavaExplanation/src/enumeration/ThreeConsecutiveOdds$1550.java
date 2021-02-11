package enumeration;

import Utils.ArrayInputUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThreeConsecutiveOdds$1550 {
    private static class Solution {
        /**
         *  give an array , if there are three consecutive odds in array , return ture,if not return false
         * @param arr 1 <= arr.length <= 1000 , 1 <= arr[i] <= 1000
         * @return does arr exist three consecutive odds
         * @TimeComplexity O(n)
         * @SpaceComplexity O(1)
         * @Since 2021-02-11
         * @TimeOver    100.00%
         * @SpaceOver   7.55%
         */
        public boolean threeConsecutiveOdds(int[] arr) {
            boolean consecutiveFlags[] = {false,false,false};
            for(int i=0;i<arr.length;i++){
                consecutiveFlags[i%3] =( arr[i] % 2 == 1 );
                if(consecutiveFlags[0] && consecutiveFlags[1] && consecutiveFlags[2])
                    return true;
            }
            return consecutiveFlags[0] && consecutiveFlags[1] && consecutiveFlags[2];
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = "CaseFiles\\Enumeration\\ThreeConsecutiveOdds_1550_Input";
        String outputFile = "CaseFiles\\Enumeration\\ThreeConsecutiveOdds_1550_Output";
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream(inputFile));
        Scanner so = new Scanner(new FileInputStream(outputFile));
        while(sc.hasNext()){
            String inputStr = sc.nextLine();
            boolean outputBool = Boolean.valueOf(so.nextLine());
            boolean res = s.threeConsecutiveOdds(ArrayInputUtils.stringTransToArray(inputStr));
            System.out.print(res == outputBool);
            System.out.println("------输入："+inputStr+"\t输出："+res);
        }
    }
}
