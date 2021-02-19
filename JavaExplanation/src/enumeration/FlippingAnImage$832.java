package enumeration;

import Utils.ArrayInputUtils;
import Utils.ArrayOutputUtils;
import Utils.CompareUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FlippingAnImage$832 {
    private static class Solution {
        /**
         * image is a binary array filled with 0 or 1 , please return the image have flipped;
         * level flip: swap the element between central axis
         * value flip: 0 to 1,1 to 0
         * @param A
         * @return
         * @TimeComplexity O(n*m/2)
         * @SpaceComplexity O(1)
         * @Since 2021-02-18
         * @TimeOver    46.14%
         * @SpaceOver   77.25%
         */
        public int[][] flipAndInvertImage(int[][] A) {
            int len = A[0].length;
            int tmp = 0;
            for(int i=0;i<A.length;i++){
                for(int j=0;j<(len+1)/2;j++){
                    tmp = 1 - A[i][len-j-1];
                    A[i][len-j-1] = 1 - A[i][j];
                    A[i][j] = tmp;
                }
            }
            return A;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = "CaseFiles\\Enumeration\\FlippingAnImage_832_Input";
        String outputFile = "CaseFiles\\Enumeration\\FlippingAnImage_832_Output";
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream(inputFile));
        Scanner so = new Scanner(new FileInputStream(outputFile));
        while(sc.hasNext()){
            String inputStr = sc.nextLine();
            String outputStr = so.nextLine();
            int[][] res = s.flipAndInvertImage(ArrayInputUtils.stringTransToBinaryIntArray(inputStr));
            System.out.print(CompareUtils.isEqual(res,ArrayInputUtils.stringTransToBinaryIntArray(outputStr)));
            System.out.println("------输入："+inputStr+"\t输出："+ ArrayOutputUtils.binaryIntegerArrayOut(res));
        }
    }
}
