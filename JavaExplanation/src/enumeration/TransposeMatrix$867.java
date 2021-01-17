package enumeration;

import Utils.ArrayInputUtils;
import Utils.ArrayOutputUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TransposeMatrix$867 {
    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\Enumeration\\TransposeMatrix_867_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles\\Enumeration\\TransposeMatrix_867_Output"));
        while(sc.hasNext()){
            String inputLine = sc.nextLine();
            String outputLine = so.nextLine();
            int[][] result = s.transpose(ArrayInputUtils.stringTransToBinaryIntArray(inputLine));
            System.out.print(outputLine.equals(ArrayOutputUtils.binaryIntegerArrayOut(result)));
            System.out.print("------");
            System.out.print("输入："+inputLine);
            System.out.print("\t输出："+ArrayOutputUtils.binaryIntegerArrayOut(result));
        }

    }
    private static class Solution {
        public int[][] transpose(int[][] A) {
            int[][] AT = new int[A[0].length][A.length];
            for(int i=0,j;i<A.length;i++)
                for(j=0;j<A[0].length;j++)
                    AT[j][i] = A[i][j];
            return AT;
        }
    }
}
