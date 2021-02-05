package enumeration.slidingwindow;

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
            int sum = 0;//计算总和
            int size = arr.length;//数组长度
            for (int len = 1; len <= size; len += 2) {//len滑动窗口长度
                sum += window(arr,len);//将每次放回的和累加到一起
            }
            return sum;
        }
        private int window(int[] arr,int len){
            //test
            //int num = 0;
            int i = 0;//左指针
            int j = 0;//右指针
            int sum = 0;//当前滑动窗口的和
            int ssum = 0;//返回的总和
            while (j < arr.length ){
                //num ++;
                sum += arr[j];
                if(j - i + 1 == len) {//长度等于len长度时就计算总和，然后移动左指针并处理当前滑动窗口的和
                    //滑动窗口和 = 原窗口和 + 后进窗口元素 - 移除窗口元素
                    ssum += sum;
                    sum -= arr[i];
                    i++;
                }
                j++;
            }
            //System.out.println(num);
            return ssum;
        }
    }
}
