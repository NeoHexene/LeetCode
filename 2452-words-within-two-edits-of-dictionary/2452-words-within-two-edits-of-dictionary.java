class Solution {

    class TrieNode {
        TrieNode child[] = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.child[c - 'a'] == null) {
                    curr.child[c - 'a'] = new TrieNode();
                }
                curr = curr.child[c - 'a'];
            }
            curr.isEnd = true;
        }
        return root;
    }

    private boolean dfs(String query, int i, TrieNode node, int count) {
        if (count > 2 || node == null) {
            return false;
        }
        if (i == query.length()) {
            return node.isEnd;
        }
        if (node.child[query.charAt(i) - 'a'] != null) {
            if (dfs(query, i + 1, node.child[query.charAt(i) - 'a'], count)) {
                return true;
            }
        }
        if (count < 2) {
            for (int c = 0; c < 26; c++) {
                if (c == query.charAt(i) - 'a') {
                    continue;
                }
                if (node.child[c] != null) {
                    if (dfs(query, i + 1, node.child[c], count + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        TrieNode root = buildTrie(dictionary);
        List<String> res = new ArrayList<>();
        for (String q : queries) {
            if (dfs(q, 0, root, 0)) {
                res.add(q);
            }
        }
        return res;
    }
}