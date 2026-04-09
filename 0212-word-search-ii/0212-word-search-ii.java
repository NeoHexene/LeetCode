class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.word = word;
        }
        return root;
    }


    public List<String> findWords(char[][] grid, String[] words) {
        TrieNode root = buildTrie(words);
        
        List<String> res = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dfs(grid, i, j, root, res);
            }
        }

        return res;
    }

    private void dfs (char[][] grid, int row, int col, TrieNode curr, List<String> res) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[row].length) {
            return;
        }
        char c = grid[row][col];
        if (c == '#' || curr.children[c - 'a'] == null) {
            return;
        }

        TrieNode next = curr.children[c - 'a'];

        if (next.word != null) {
            res.add(next.word);
            next.word = null;
        }

        grid[row][col] = '#';

        dfs(grid, row + 1, col, next, res);
        dfs(grid, row - 1, col, next, res);
        dfs(grid, row, col + 1, next, res);
        dfs(grid, row, col - 1, next, res);

        grid[row][col] = c;
        
        return;
    }
}