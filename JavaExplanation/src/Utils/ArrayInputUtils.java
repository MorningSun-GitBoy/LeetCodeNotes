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
}
