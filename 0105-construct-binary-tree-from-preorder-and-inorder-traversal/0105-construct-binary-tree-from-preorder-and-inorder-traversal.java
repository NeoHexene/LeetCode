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

    private TreeNode dfs(int[] inorder, int[] preorder, int i, int j, int idx, Map<Integer, Integer> map) {
        
        if (i > j) {
            return null;
        }

        TreeNode curr = new TreeNode(preorder[idx]);
        int currIdx = map.get(curr.val);

        curr.left = dfs(inorder, preorder, i, currIdx - 1, idx + 1, map);

        int leftSize = currIdx - i;
        curr.right = dfs(inorder, preorder, currIdx + 1, j, idx + leftSize + 1, map);

        return curr;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(inorder, preorder, 0, inorder.length - 1, 0, map);
    }
}