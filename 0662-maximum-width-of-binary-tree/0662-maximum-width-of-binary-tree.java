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

class Pair {

    TreeNode node;
    int idx;

    Pair(TreeNode node, int idx) {
        this.node = node;
        this.idx = idx;
    }
}

class Solution {
    
    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int width = 1;

        while (!q.isEmpty()) {
            
            int size = q.size();
            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {

                Pair pair = q.poll();

                if (i == 0) {
                    first = pair.idx;
                }

                if (i == size - 1) {
                    last = pair.idx;
                }

                if (pair.node.left != null) {
                    q.offer(new Pair(pair.node.left, 2 * (pair.idx - 1) + 1));
                }

                if (pair.node.right != null) {
                    q.offer(new Pair(pair.node.right, 2 * (pair.idx - 1) + 2));
                }
            }

            width = Math.max(width, last - first + 1);
        }    

        return width;
    }
}