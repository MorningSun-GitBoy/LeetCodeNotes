package recursion;

import Utils.ArrayInputUtils;
import Utils.ArrayOutputUtils;
import Utils.CompareUtils;
import Utils.ListNodeUtils;
import baseclasses.ListNode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PrintLinkedListFromTailToHead$m06 {
    private static class Solution{
        ArrayList<Integer> res = new ArrayList<Integer>();//to store result
        /**
         * give you a head of ListNode,than print it into array from tail to head
         * @param head 0 <= ListNode length <= 10000
         * @return
         * @TimeComplexity O(n)
         * @SpaceComplexity O(n)
         * @Since 2021-02-18
         * @TimeOver    72.08%
         * @SpaceOver   6.51%
         */
        public int[] reversePrint(ListNode head){
            recursion(head);
            int len = this.res.size();
            int[] res = new int[len];
            for(int i=0;i<len;i++){
                res[i] = this.res.get(i);
            }
            return res;
        }
        private void recursion(ListNode head){
            if(head == null) return;
            recursion(head.next);
            res.add(head.val);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = "CaseFiles\\Stack\\PrintLinkedListFromTailToHead_m06_Input";
        String outputFile = "CaseFiles\\Stack\\PrintLinkedListFromTailToHead_m06_Output";
        Solution s = new Solution();
        Scanner sc = new Scanner(new FileInputStream(inputFile));
        Scanner so = new Scanner(new FileInputStream(outputFile));
        while(sc.hasNext()){
            String inputStr = sc.nextLine();
            String outputStr = so.nextLine();
            ListNode head = ListNodeUtils.stringTransferListNode(inputStr);
            int res[] = s.reversePrint(head);
            System.out.print(CompareUtils.isEqual(res, ArrayInputUtils.stringTransToArray(outputStr)));
            System.out.println("------输入："+inputStr+"\t输出："+ ArrayOutputUtils.integerArrayOut(res));
        }
    }
}
