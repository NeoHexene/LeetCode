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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode prev1 = null;
        int carry = 0;
        int sum = 0;

        while (curr1 != null && curr2 != null) {
            sum = curr1.val + curr2.val + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            curr1.val = sum;
            prev1 = curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr2 != null) {
            sum = curr2.val + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            ListNode newNode = new ListNode(sum, null);
            prev1.next = newNode;
            prev1 = prev1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            sum = curr1.val + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            curr1.val = sum;
            prev1 = curr1;
            curr1 = curr1.next;
        }

        if (carry != 0) {
            ListNode newNode = new ListNode(carry, null);
            prev1.next = newNode;
        }

        return l1;
    }
}