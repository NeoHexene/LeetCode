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

    private TreeNode buildTree(int[] preorder, int[] idx, int ub) {

        if (idx[0] == preorder.length || preorder[idx[0]] > ub) {
            return null;
        }

        TreeNode curr = new TreeNode(preorder[idx[0]]);
        idx[0]++;

        curr.left = buildTree(preorder, idx, curr.val);
        curr.right = buildTree(preorder, idx, ub);

        return curr;
    }

    // Changed Integer idx to int[] idx because Integer is immutable, whereas an array is mutable, allowing all recursive calls to update and share the same index.
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, new int[]{0}, Integer.MAX_VALUE);
    }
}