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

    private int[] postOrder(TreeNode root, int count) {
        if (root == null) {
            return new int[]{-1, 0};
        }

        int[] left = postOrder(root.left, 0);
        int[] right = postOrder(root.right, 0);

        if (left[0] <= root.val && root.val >= right[0]) {
            return new int[]{root.val, left[1] + right[1] + 1};
        }

        return new int[]{Math.max(left[0], right[0]), left[1] + right[1]};
    }

    public int countDominantNodes(TreeNode root) {
        return postOrder(root, 0)[1];
    }
}