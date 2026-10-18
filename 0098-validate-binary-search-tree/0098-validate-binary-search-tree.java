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

    public boolean isValidBST(TreeNode root) {

        TreeNode curr = root;
        TreeNode last = null;

        boolean valid = true;

        while (curr != null) {

            if (curr.left == null) {

                if (last != null && last.val >= curr.val) {
                    valid = false;
                }
                last = curr;
                curr = curr.right;
            } else {

                TreeNode prev = curr.left;

                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    if (last != null && last.val >= curr.val) {
                        valid = false;
                    }
                    last = curr;
                    curr = curr.right;
               }
            }
        }

        return valid;
    }
}