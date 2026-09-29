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


class NodeInfo {
    TreeNode node;
    int row;
    int col;

    NodeInfo(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Queue<NodeInfo> q = new LinkedList<>();
        q.offer(new NodeInfo(root, 0, 0));

        // Vertical -> Horizontal -> Sorted List of nodes for vertical, horizontal
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // BFS traversal over the horizontal axis.
        while (!q.isEmpty()) {

            NodeInfo nodeInfo = q.poll();

            map.putIfAbsent(nodeInfo.col, new TreeMap<>());
            map.get(nodeInfo.col).putIfAbsent(nodeInfo.row, new PriorityQueue<>());

            if (nodeInfo.node.left != null) {
                q.offer(new NodeInfo(nodeInfo.node.left, nodeInfo.row + 1, nodeInfo.col - 1));
            }

            if (nodeInfo.node.right != null) {
                q.offer(new NodeInfo(nodeInfo.node.right, nodeInfo.row + 1, nodeInfo.col + 1));
            }

            map.get(nodeInfo.col).get(nodeInfo.row).offer(nodeInfo.node.val);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> row : map.values()) {
            
            List<Integer> colValues = new ArrayList<>();

            for (PriorityQueue<Integer> pq : row.values()) {
                
                while (!pq.isEmpty()) {
                    colValues.add(pq.poll());
                }
            }

            res.add(colValues);
        } 

        return res;
    }
}