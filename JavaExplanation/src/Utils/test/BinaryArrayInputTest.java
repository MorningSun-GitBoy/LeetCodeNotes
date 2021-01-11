package Utils.test;

import Utils.ArrayInputUtils;

public class BinaryArrayInputTest {
    public static void main(String[] args) {
        int[][] res = ArrayInputUtils.stringTransToBinaryIntArray("[[1,5,7,6],[3,2,4,4],[1,1,1,1]]");
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                System.out.println(res[i][j]);
            }
        }
    }
}
