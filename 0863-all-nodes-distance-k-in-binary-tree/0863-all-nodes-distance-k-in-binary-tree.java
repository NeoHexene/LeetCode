/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    private void setParentNodes(TreeNode root, Map<TreeNode, TreeNode> parentMap) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        parentMap.put(root, null);

        while (!q.isEmpty()) {
        
            TreeNode node = q.poll();

            if (node.left != null) {
                q.offer(node.left);
                parentMap.put(node.left, node);
            }

            if (node.right != null) {
                q.offer(node.right);
                parentMap.put(node.right, node);
            }

        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        setParentNodes(root, parentMap);

        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
            
        q.offer(target);
        visited.put(target, true);

        int dist = 0;

        while (!q.isEmpty() && dist < k) {

            int size = q.size();

            while (size > 0) {

                TreeNode node = q.poll();

                if (node.left != null && visited.get(node.left) == null) {
                    q.offer(node.left);
                    visited.put(node.left, true);
                }

                if (node.right != null && visited.get(node.right) == null) {
                    q.offer(node.right);
                    visited.put(node.right, true);
                }

                if (parentMap.get(node) != null && visited.get(parentMap.get(node)) == null) {
                    q.offer(parentMap.get(node));
                    visited.put(parentMap.get(node), true);
                }

                size--;
            }

            dist++;
            
        }

        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            res.add(q.poll().val);
        }

        return res;

    }
}