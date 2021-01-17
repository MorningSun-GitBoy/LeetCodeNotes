package Utils;

import baseclasses.TreeNode;

public class BinaryTreeUtils {
    public static void preOrderTravel(TreeNode root){
        if(root == null)    return;
        System.out.println(root.val);
        preOrderTravel(root.left);
        preOrderTravel(root.right);
    }
    public static void midOrderTravel(TreeNode root){
        if(root == null)    return;
        midOrderTravel(root.left);
        System.out.println(root.val);
        midOrderTravel(root.right);
    }
    public static void afterOrderTravel(TreeNode root){
        if(root==null)  return;
        afterOrderTravel(root.left);
        afterOrderTravel(root.right);
        System.out.println(root.val);
    }
}
