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
        ListNode head = null;
        ListNode currNode = null;
        ListNode prevNode = null;
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                if (head == null) {
                    head = curr1;
                }
                prevNode = currNode;
                currNode = curr1;
                if (prevNode != null) {
                    prevNode.next = currNode;
                }
                curr1 = curr1.next;
            } else {
                if (head == null) {
                    head = curr2;
                    
                }
                prevNode = currNode;
                currNode = curr2;
                if (prevNode != null) {
                    prevNode.next = currNode;
                }
                curr2 = curr2.next;
            }
        }
        if (curr1 != null) {
            while (curr1 != null) {
                if (head == null) {
                    head = curr1;
                    
                }
                prevNode = currNode;
                currNode = curr1;
                if (prevNode != null) {
                    prevNode.next = currNode;
                }
                curr1 = curr1.next;
            }
        }
        if (curr2 != null) {
            while (curr2 != null) {
                if (head == null) {
                    head = curr2;
                    
                }
                prevNode = currNode;
                currNode = curr2;
                if (prevNode != null) {
                    prevNode.next = currNode;
                }
                curr2 = curr2.next;
            }
        }
        return head;
    }
}