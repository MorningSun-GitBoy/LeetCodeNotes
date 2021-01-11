package Utils;

public class ArrayInputUtils {
    public static int[] stringTransToArray(String input){
        input = input.substring(1,input.length()-1);
        String[] parts = input.split(",");
        int res[] = new int[parts.length];
        for(int i=0;i<parts.length;i++){
            res[i] = Integer.valueOf(parts[i]);
        }
        return res;
    }
    public static int[][] stringTransToBinaryIntArray(String input){
        input = input.substring(1,input.length()-2);//裁剪掉后面的]]
        //System.out.println(input);
        String[] parts = input.split("],");//为了方便区分第一级和第二级
        //System.out.println(parts[0]);
        String[] strArr = parts[0].split(",");
        int res[][] = new int[parts.length][strArr.length];
        for(int i=0;i<res.length;i++){
            //System.out.println(arrStr);
            strArr = parts[i].substring(1,parts[i].length()).split(",");//待剪切的数据变成了[1,1,1,1，只需要剪切掉最开始的[
            for(int j=0;j<strArr.length;j++){
                res[i][j] = Integer.valueOf(strArr[j]);
            }
        }
        return res;
    }
}
