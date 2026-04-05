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
    /*
    INTUITION:
    Each linked list represents a number in reverse order.
    Example:
        l1 = 2 -> 4 -> 3   (represents 342)
        l2 = 5 -> 6 -> 4   (represents 465)

    We add digit by digit (just like normal addition),
    while keeping track of carry.

    Key idea:
    - Traverse both lists together
    - Add corresponding digits + carry
    - Store result in l1 (in-place)
    - Handle remaining nodes if lengths differ
    - If carry remains at the end, create a new node
    */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode curr1 = l1;   // pointer for first list
        ListNode curr2 = l2;   // pointer for second list
        ListNode prev1 = null; // to keep track of last node of result

        int carry = 0;
        int sum = 0;

        // Step 1: Traverse both lists together
        while (curr1 != null && curr2 != null) {

            // Add digits and carry
            sum = curr1.val + curr2.val + carry;

            // Update carry and current digit
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            // Store result in l1 (in-place)
            curr1.val = sum;

            // Move pointers forward
            prev1 = curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        // Step 2: If l2 is longer
        while (curr2 != null) {

            sum = curr2.val + carry;

            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            // Create new node and attach to result
            ListNode newNode = new ListNode(sum);
            prev1.next = newNode;

            prev1 = newNode;
            curr2 = curr2.next;
        }

        // Step 3: If l1 is longer
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

        // Step 4: If carry is still left
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            prev1.next = newNode;
        }

        return l1;
    }
}