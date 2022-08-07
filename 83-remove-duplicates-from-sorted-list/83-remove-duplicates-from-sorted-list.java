/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        if (head == null) {
            return head;
        }
        while (p!=null) {
            if (p.next == null) {
                break;
            }
            else if (p.val == p.next.val) {
                p.next = p.next.next;
            }
            else {
                p = p.next;
            }
        }
        return head;
    }
}