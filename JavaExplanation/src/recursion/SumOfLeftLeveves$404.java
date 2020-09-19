package recursion;

import baseclasses.TreeNode;

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
