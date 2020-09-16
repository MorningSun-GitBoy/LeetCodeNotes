package recursion;

import baseclasses.TreeNode;

/**
 * @TimeComplexity  O(n)
 * @SpaceComplexity O(n)
 * @Since 2020-09-16
 * @TimeOver    100%
 * @SpaceOver   28.15%
 */
public class InvertBinaryTree$226 {
    public static void main(String[] args) {

    }
    private static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null)
                return root;
            TreeNode tmp = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = tmp;
            return root;
        }
    }
}
