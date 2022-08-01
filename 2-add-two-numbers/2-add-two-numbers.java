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
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, res = result;
        int carry = 0, x, y;
        while (p!=null || q!=null || carry !=0) {  // Loop should go on until we reach the null value for each linked list and carry should be 0
            if (p!=null) {
                x = p.val;
            }
            else {
                x = 0;
            }
            if (q!=null) {
                y = q.val;
            }
            else {
                y = 0;
            }
            int sum = 0;
            sum = sum + carry + x + y; // it will provide sum of the values present in the 2 linked list
            carry = sum/10;
            res.next = new ListNode (sum % 10); 
            res = res.next;
            if (p!=null) {
                p = p.next;
            }
            if (q!=null) {
                q = q.next;
            }
        }
        return result.next; // result.next will point towards the linked list res, so we need to return result.next in order to get res linked list which will have answer
    }
}