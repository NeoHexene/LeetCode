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

    private void reverse(ListNode head) {
        
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return;
    }

    private ListNode getkthNode(ListNode head, int k) {
        
        ListNode curr = head;
        ListNode prev = null;
        int i = 1;

        while (i < k && curr != null) {
            i++;
            curr = curr.next;
        }

        return curr;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;

        while (curr != null) {
            ListNode kth = getkthNode(curr, k);
            if (kth == null) {
                break;
            }
            ListNode nextNode = kth.next;
            kth.next = null;
            prev.next = null;
            reverse(curr);
            prev.next = kth;
            curr.next = nextNode;
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}