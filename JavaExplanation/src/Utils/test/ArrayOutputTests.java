package Utils.test;

import Utils.ArrayOutputUtils;

public class ArrayOutputTests {
    public static void main(String[] args) {
        //Int binary array
        int[][] arr = {{112,344,242},{2424,455,3366}};
        System.out.println(ArrayOutputUtils.binaryIntegerArrayOut(arr));
    }
}
