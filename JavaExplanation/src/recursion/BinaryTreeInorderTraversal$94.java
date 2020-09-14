package recursion;

import baseclasses.TreeNode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @TimeComplexity  O(nlogn)
 * @SpaceComplexity O(1)
 * @Since 2020-09-14
 * @TimeOver    100%
 * @SpaceOver   37.08%
 */
public class BinaryTreeInorderTraversal$94 {
    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\Recursion\\BinaryTreeInorderTraversal_94_ Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles\\Recursion\\BinaryTreeInorderTraversal_94_ Output"));
    }
    private static class Solution {
        List<Integer> nodes;
        public List<Integer> inorderTraversal(TreeNode root) {
            nodes = new ArrayList<Integer>();
            inorder(root);
            return nodes;
        }
        public void inorder(TreeNode root){
            if(root != null){
                inorder(root.left);
                nodes.add(root.val);
                inorder(root.right);
            }
        }
    }
}
