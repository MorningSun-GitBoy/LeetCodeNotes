package Utils;

import baseclasses.ListNode;

public class ListNodeUtils {
    public static ListNode arrayTransferListNode(int[] valueArr){
        ListNode head = new ListNode(valueArr[0]);
        ListNode index = head;
        for(int i=1;i<valueArr.length;i++){
            index.next = new ListNode(valueArr[i]);
            index = index.next;
        }
        return head;
    }
    public static ListNode stringTransferListNode(String str){
        return arrayTransferListNode(ArrayInputUtils.stringTransToArray(str));
    }
}
