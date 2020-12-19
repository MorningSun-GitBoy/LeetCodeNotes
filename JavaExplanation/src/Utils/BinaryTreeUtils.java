package Utils;

import baseclasses.TreeNode;

public class BinaryTreeUtils {
    public static void preOrderTravel(TreeNode root){
        if(root == null)    return;
        System.out.println(root.val);
        preOrderTravel(root.left);
        preOrderTravel(root.right);
    }
}
