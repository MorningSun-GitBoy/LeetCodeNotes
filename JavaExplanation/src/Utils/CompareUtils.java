package Utils;

public class CompareUtils {
    public static boolean isEqual(int[] arr1,int[] arr2){
        if(arr1.length == arr2.length){
            for(int i=0;i<arr1.length;i++){
                if(arr1[i]!=arr2[i]) return false;
            }
            return true;
        }
        return false;
    }
}
