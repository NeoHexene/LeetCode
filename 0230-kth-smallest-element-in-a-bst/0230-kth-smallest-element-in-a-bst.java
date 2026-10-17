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

    /*
    Brute Force:

    private void dfs(TreeNode root, List<Integer> data) {
        if (root.left != null) {
            dfs(root.left, data);
        }
        data.add(root.val);
        if (root.right != null) {
            dfs(root.right, data);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> data = new ArrayList<>();
        
        dfs(root, data);

        return data.get(k - 1);
    }

    */

    public int kthSmallest(TreeNode root, int k) {
        
        TreeNode curr = root;
        int count = 0;

        // Using Morris Traversal
        while (curr != null) {

            if (curr.left == null) {
                count++;
                if (count == k) {
                    return curr.val;
                }
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
                    count++;
                    if (count == k) {
                        return curr.val;
                    }
                    curr = curr.right;
                }

            }
        }

        return -1;
    }
}