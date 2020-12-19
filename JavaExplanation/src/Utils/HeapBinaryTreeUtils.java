package Utils;

import baseclasses.TreeNode;

public class HeapBinaryTreeUtils {
    public static void heapToBinaryTree(TreeNode root, String heap){
        if(heap.length()<3) {
            root = null;
            return;
        }
        String arr[] = heap.substring(1,heap.length()-1).split(",");
        /*for(String str : arr){
            System.out.println(str);
        }*/
        root.val = Integer.valueOf(arr[0]);
        insertTreeNode(root,1,arr);
        insertTreeNode(root,2,arr);
    }
    private static void insertTreeNode(TreeNode root,int index,String[] arr){
        if(root==null)  return;
        int i = index;
        if(i>=arr.length)   return;
        if(arr[i].equals("null"))   return;
        if(i % 2 == 1){
            root.left = new TreeNode(Integer.valueOf(arr[i]));
            i = i*2 + 1;
            if(i<arr.length)    insertTreeNode(root.left,i++,arr);
            if(i<arr.length)    insertTreeNode(root.left,i,arr);
        }
        if(i % 2 == 0){
            root.right = new TreeNode(Integer.valueOf(arr[i]));
            i = i*2 + 1;
            if(i<arr.length)    insertTreeNode(root.right,i++,arr);
            if(i<arr.length)    insertTreeNode(root.right,i,arr);
        }
    }
}
