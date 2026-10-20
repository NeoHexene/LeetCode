/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private TreeNode first = null, middle = null, last = null;

    private void inorder(TreeNode curr) {

        TreeNode prev = null;

        while (curr != null) {
            if (curr.left == null) {

                if (prev != null && prev.val > curr.val) {
                    if (first != null) {
                        last = curr;
                    } else {
                        first = prev;
                        middle = curr;
                    }
                }
                prev = curr;
                curr = curr.right;
            } else {

                TreeNode temp = curr.left;

                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }

                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    temp.right = null;
                    if (prev != null && prev.val > curr.val) {
                        if (first != null) {
                            last = curr;
                        } else {
                            first = prev;
                            middle = curr;
                        }
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
    }

    public void recoverTree(TreeNode root) {
        
        inorder(root);

        if (last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}