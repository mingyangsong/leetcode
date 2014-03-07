/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slow = head;
        ListNode quick = head;
        while(quick.next!=null && quick.next.next!=null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow){
                return true;
            }
        }
        return false;
    }
}
