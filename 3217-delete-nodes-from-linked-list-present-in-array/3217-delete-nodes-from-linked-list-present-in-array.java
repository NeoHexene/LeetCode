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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (set.contains(curr.val)) {
                if (curr == head) {
                    curr = curr.next;
                    head = head.next;
                } else {
                    if (prev != null) {
                        prev.next = curr.next;
                        curr = curr.next;
                    } else {
                        curr = curr.next;
                    }
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }
}