/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode dummy = new ListNode(0);
        dummy.next=l1;
        ListNode prev=dummy;
        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                prev.next=l2;
                l2=l1;
            }
            prev = prev.next;
            l1=prev.next;
        }
        prev.next=l2;
        return dummy.next;
    }
}
