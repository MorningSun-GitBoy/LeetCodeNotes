package recursion;

import baseclasses.TreeNode;

/**
 * @TimeComplexity  O(nlogn)
 * @SpaceComplexity O(1)
 * @Since 2020-09-19
 * @TimeOver    100%
 * @SpaceOver   84.78%
 */
public class SumOfLeftLeveves$404 {
    public static void main(String[] args) {

    }
    private static class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            int sum = 0;
            if(root == null) return 0;
            if(root.left!=null && root.left.left==null && root.left.right==null)
                sum += root.left.val;
            return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}
