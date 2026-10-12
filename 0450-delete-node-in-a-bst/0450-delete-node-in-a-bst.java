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

    private TreeNode leftMostNode(TreeNode root) {

        TreeNode curr = root;

        while (curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }

    private TreeNode replacement(TreeNode root) {
        
        if (root.right == null) {
            return root.left;
        } 
        if (root.left == null) {
            return root.right;
        }

        TreeNode rightChild = root.right;
        TreeNode leftChild = root.left;

        TreeNode leftMost = leftMostNode(rightChild);
        leftMost.left = leftChild;

        return rightChild;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return replacement(root);
        }

        TreeNode curr = root;

        while (curr != null) {
            if (curr.val > key) {
                if (curr.left != null && curr.left.val == key) {
                    curr.left = replacement(curr.left);
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right != null && curr.right.val == key) {
                    curr.right = replacement(curr.right);
                } else {
                    curr = curr.right;
                }
            }
        }

        return root;
    }
}