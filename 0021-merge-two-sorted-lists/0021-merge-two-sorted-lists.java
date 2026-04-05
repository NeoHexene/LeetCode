/*
INTUITION:
We are given two sorted linked lists and need to merge them into one sorted list.

Since both lists are already sorted:
- At each step, we just need to pick the smaller node from the two lists
- Attach it to our result list
- Move forward in that list

This is similar to the "merge step" in merge sort.

-----------------------------------------------------

BRUTE FORCE APPROACH:

- Copy all elements from both lists into an array/list
- Sort the array
- Create a new linked list from sorted values

Time Complexity: O((n + m) log(n + m))  
Space Complexity: O(n + m)

-----------------------------------------------------

OPTIMIZED APPROACH (USED HERE):

Use two pointers:
- One for list1
- One for list2

And a dummy node to simplify edge cases.

Process:
- Compare values of both lists
- Attach the smaller one to result
- Move pointer forward
- Repeat until one list is exhausted
- Attach the remaining part directly

-----------------------------------------------------

IMPLEMENTED LOGIC:

- Create a dummy head node (helps avoid null checks)
- Use a pointer `curr` to build the result list
- While both lists are not null:
    - Compare values
    - Attach smaller node
    - Move pointer
- After loop:
    - Attach remaining nodes (only one list will have elements)
- Return head.next (skip dummy node)

-----------------------------------------------------

TIME COMPLEXITY:
O(n + m)

SPACE COMPLEXITY:
O(1)  (no extra space, reusing nodes)
*/

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node to simplify list construction
        ListNode head = new ListNode();

        // Pointer to build the merged list
        ListNode curr = head;

        // Traverse both lists
        while (list1 != null && list2 != null) {

            // Pick the smaller value node
            if (list1.val < list2.val) {
                curr.next = list1;     // attach list1 node
                list1 = list1.next;    // move list1 forward
            } else {
                curr.next = list2;     // attach list2 node
                list2 = list2.next;    // move list2 forward
            }

            // Move current pointer forward
            curr = curr.next;
        }

        // Attach the remaining nodes (only one list will have elements left)
        curr.next = (list1 != null) ? list1 : list2;

        // Return merged list (skip dummy node)
        return head.next;
    }
}