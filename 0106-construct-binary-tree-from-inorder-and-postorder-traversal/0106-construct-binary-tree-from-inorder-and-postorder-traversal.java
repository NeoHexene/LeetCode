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

    int postindex;

    private TreeNode construct(int[] inorder, int[] postorder, int instart, int inend, Map<Integer, Integer> map) {
        if (instart > inend) {
            return null;
        }

        int rootVal = postorder[postindex--];
        TreeNode root = new TreeNode(rootVal);

        int rootindex = map.get(rootVal);

        root.right = construct(inorder, postorder, rootindex + 1, inend, map);
        root.left = construct(inorder, postorder, instart, rootindex - 1, map);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postindex = postorder.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(inorder, postorder, 0, inorder.length - 1, map);
    }
}