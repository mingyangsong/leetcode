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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(head!=null&&head.next!=null){
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = head;
            prev.next = temp;
            prev = head;
            head = head.next;
        }
        return dummy.next;
    }
}
