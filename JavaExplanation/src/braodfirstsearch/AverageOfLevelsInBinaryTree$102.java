package braodfirstsearch;

import Utils.HeapBinaryTreeUtils;
import baseclasses.TreeNode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @TimeComplexity  O(n)
 * @SpaceComplexity O(n)
 * @Since 2020-09-11
 * @TimeOver    99.17%
 * @SpaceOver   46.25%
 */
public class AverageOfLevelsInBinaryTree$102 {
    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream("CaseFiles\\BraodFirstSearch\\AverageOfLevelsInBinaryTree_102_Input"));
        Scanner so = new Scanner(new FileInputStream("CaseFiles\\BraodFirstSearch\\AverageOfLevelsInBinaryTree_102_Output"));
        while(sc.hasNext()){
            String inputHeap = sc.nextLine();
            String resStr = so.nextLine();
            TreeNode root = new TreeNode(0);
            HeapBinaryTreeUtils.heapToBinaryTree(root,inputHeap);
            List<Double> res = s.averageOfLevels(root);
            //System.out.print(resStr.equals(res.toString()));//格式不同所以需要转换
            boolean isEquals = true;
            String ress[] = resStr.substring(1,resStr.length()-1).split(",");
            for(int i=0;i<ress.length;i++){
                isEquals = isEquals&&res.get(i).equals(Double.valueOf(ress[i]));
            }
            System.out.print(isEquals);
            System.out.print("-------");
            System.out.println(inputHeap+"\t"+res.toString());
        }
    }
    private static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> averages = new ArrayList<Double>();
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                double sum = 0;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    TreeNode left = node.left, right = node.right;
                    if (left != null) {
                        queue.offer(left);
                    }
                    if (right != null) {
                        queue.offer(right);
                    }
                }
                averages.add(sum / size);
            }
            return averages;
        }
    }
}
