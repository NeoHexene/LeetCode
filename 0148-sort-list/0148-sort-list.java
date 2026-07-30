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

    private ListNode middleNode(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode mergeSort(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = middleNode(head);

        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;

        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);
        
        return merge(leftHead, rightHead);
    }

    private ListNode merge(ListNode leftHead, ListNode rightHead) {
        
        ListNode currL = leftHead, currR = rightHead;
        ListNode newHead = new ListNode(-1);
        ListNode curr = newHead;
        
        while (currL != null && currR != null) {
            if (currL.val < currR.val) {
                curr.next = currL;
                currL = currL.next;
            } else {
                curr.next = currR;
                currR = currR.next;
            }
            curr = curr.next;
        }

        while (currL != null) {
            curr.next = currL;
            currL = currL.next;
            curr = curr.next;
        }

        while (currR != null) {
            curr.next = currR;
            currR = currR.next;
            curr = curr.next;
        }

        return newHead.next;
    }


    public ListNode sortList(ListNode head) {
        
        /* 
        Brute force:
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        Collections.sort(list);

        curr = head;
        int i = 0;

        while (curr != null) {
            curr.val = list.get(i++);
            curr = curr.next;
        }

        return head;
        */

        return mergeSort(head);
    }
}