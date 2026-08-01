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

    private ListNode reverse(ListNode head) {
        
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private int numberOfNodes(ListNode head) {

        ListNode curr = head;
        int count = 0;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

    private ListNode getKthNode(ListNode head, int k) {
        
        ListNode curr = head;
        int i = 1;

        while (i < k && curr != null) {
            i++;
            curr = curr.next;
        }

        return curr;
    }

    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null) {
            return head;
        }

        int n = numberOfNodes(head);

        k = k % n;

        if (k == 0 || k == n) {
            return head;
        }

        head = reverse(head);

        ListNode kth = getKthNode(head, k);

        ListNode prev = head;
        ListNode next = kth.next;
        kth.next = null;

        head = reverse(head);
        prev.next = reverse(next);

        return head;
    }
}