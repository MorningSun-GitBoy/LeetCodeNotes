package Utils.test;

import Utils.BinaryTreeUtils;
import Utils.HeapBinaryTreeUtils;
import baseclasses.TreeNode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HeapBinaryTreeUtilTest {
    public static void main(String[] args) throws FileNotFoundException {
        TreeNode root = new TreeNode(0);
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\BraodFirstSearch\\AverageOfLevelsInBinaryTree_102_Input"));
        HeapBinaryTreeUtils.heapToBinaryTree(root,sc.nextLine());
        BinaryTreeUtils.preOrderTravel(root);
    }
}
