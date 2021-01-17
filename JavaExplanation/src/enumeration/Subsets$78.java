package enumeration;

import java.util.ArrayList;
import java.util.List;

/**
 * @TimeComplexity  O(2^n)
 * @SpaceComplexity O(n)
 * @Since 2020-09-20
 * @TimeOver    99.39%
 * @SpaceOver   82.03%
 */
public class Subsets$78 {
    public static void main(String[] args) {

    }
    private static class Solution {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            for (int mask = 0; mask < (1 << n); ++mask) {
                t.clear();//清空临时集合
                for (int i = 0; i < n; ++i) {
                    if ((mask & (1 << i)) != 0) {
                        t.add(nums[i]);
                    }
                }
                ans.add(new ArrayList<Integer>(t));//将新对象加入到结果集中
            }
            return ans;
        }
    }
}
