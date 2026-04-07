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

 /*
INTUITION:
We need to remove the N-th node from the end of a linked list.

Instead of calculating the length first (two passes),
we can solve it in ONE PASS using two pointers.

-----------------------------------------------------

CORE IDEA (TWO POINTERS):

- Move a fast pointer `n` steps ahead
- Then move both fast and slow pointers together
- When fast reaches the end:
    → slow will be just before the node to delete

-----------------------------------------------------

WHY THIS WORKS:

The gap between fast and slow is always `n`.

So when fast reaches the last node:
- slow is at (n+1)th node from the end
- slow.next is the node we need to remove

-----------------------------------------------------

EDGE CASE:

If after moving `n` steps, fast becomes null:
    It means we need to remove the head

-----------------------------------------------------

BRUTE FORCE APPROACH:

- Find length of list
- Remove (length - n)th node

Time: O(n)
Space: O(1)
But requires 2 passes

-----------------------------------------------------

OPTIMIZED APPROACH (USED HERE):

Two pointers → single pass

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(1)
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Edge case: empty list
        if (head == null) {
            return head;
        }

        ListNode fast = head;

        // Step 1: Move fast pointer n steps ahead
        int i = 0;
        while (i < n) {
            fast = fast.next;
            i += 1;
        }

        // If fast is null → remove head
        if (fast == null) {
            return head.next;
        }

        ListNode slow = head;

        // Step 2: Move both pointers until fast reaches last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 3: Remove the target node
        slow.next = slow.next.next;

        return head;
    }
}