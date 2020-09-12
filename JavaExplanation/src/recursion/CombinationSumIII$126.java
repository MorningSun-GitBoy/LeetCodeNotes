package recursion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @TimeComplexity  O(n)
 * @SpaceComplexity O(1)
 * @Since 2020-09-11
 * @TimeOver    100%
 * @SpaceOver   51.15%
 */
public class CombinationSumIII$126 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("CaseFiles/Recursion/CombinationSum_III_126_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles/Recursion/CombinationSum_III_126_Output"));
        while(sc.hasNext()){
            int k = sc.nextInt();
            int n = sc.nextInt();
            String resStr = so.nextLine();
        }
    }
    private static class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        public List<List<Integer>> combinationSum3(int k, int n) {
            backTrack(1, k, n);
            return res;
        }

        private void backTrack(int start, int k, int n) {
            if (k == 0 && n == 0) {
                res.add(new ArrayList<>(list));
                return ;
            }
            if (k <= 0 || n < start) return ;
            for (int i = start; i <= 9; i++) {
                list.add(i);
                backTrack(i + 1, k - 1, n - i);
                list.remove(list.size() - 1);
            }
        }
    }
}
