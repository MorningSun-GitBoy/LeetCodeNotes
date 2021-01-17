package dynamicprograming;

import enumeration.SudokuSolver$37;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class NonOverlappingIntervals$435 {
    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\Dynamic-Programing\\NonOverlappingIntervals_435_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles\\Dynamic-Programing\\NonOverlappingIntervals_435_Output"));
        while(sc.hasNext()){
            
        }
    }
    private static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }

            /*Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] interval1, int[] interval2) {
                    return interval1[0] - interval2[0];
                }
            });*/
            /*
            以上是使用自定义匿名类实现的，
            个人更推崇使用lamada表达式:Arrays.sort(intervals,(a1,a2)->a1[0]-a2[0]);
            但是IDEA推荐我使用下面的写法，即使用Comparator的写法
             */
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int n = intervals.length;
            int[] f = new int[n];
            Arrays.fill(f, 1);
            for (int i = 1; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (intervals[j][1] <= intervals[i][0]) {
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
            }
            return n - Arrays.stream(f).max().getAsInt();
        }
    }
}
