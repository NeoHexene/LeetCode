/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    private void copyNodes(Node head) {

        Node curr = head;
        while (curr != null) {
            Node copy = new Node (curr.val);
            Node next = curr.next;
            curr.next = copy;
            copy.next = next;
            curr = next;
        }
    }

    private void linkRandom(Node head) {

        Node curr = head;
        while (curr != null) {
            Node copy = curr.next;

            if (curr.random != null) {
                copy.random = curr.random.next;
            } else {
                copy.random = null;
            }

            curr = copy.next;
        }
    }

    private Node separateLists(Node head) {

        Node dummy = new Node(-1);
        Node temp = dummy;
        Node curr = head;

        while (curr != null) {
            temp.next = curr.next;
            temp = temp.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }

        return dummy.next;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        copyNodes(head);
        linkRandom(head);
        return separateLists(head);
    }
}