package Utils;

public class ArrayOutputUtils {
    public static String binaryIntegerArrayOut(int[][] arr){
        StringBuilder builder = new StringBuilder("[");
        for(int i=0,j=0;i<arr.length;i++){
            builder.append("[");
            for(j=0;j<arr[0].length;j++){
                builder.append(arr[i][j]);
                builder.append(",");
            }
            builder.deleteCharAt(builder.length()-1);
            builder.append("],");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("]");
        return builder.toString();
    }
    public static String integerArrayOut(int[] arr){
        StringBuilder builder = new StringBuilder("[");
        for(int i=0;i<arr.length;i++){
            builder.append(arr[i]);
            if(i<arr.length-1){
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
