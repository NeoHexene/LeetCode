/*
INTUITION:
We are given:
- A 2D board of characters
- A list of words

We need to find all words that can be formed by:
- Starting from any cell
- Moving in 4 directions (up, down, left, right)
- Not reusing the same cell in a single path

-----------------------------------------------------

NAIVE / BRUTE FORCE:

For each word:
- Start DFS from every cell
- Try to match the word character by character

Problems:
- Repeats work for common prefixes
- Very slow when words share prefixes

Time: O(W * M * N * 4^L)

-----------------------------------------------------

OPTIMIZED APPROACH (USED HERE):

Use:
    Trie (Prefix Tree) + DFS (Backtracking)

Why Trie?
- Stores all words efficiently
- Allows prefix pruning
- If a path is not a prefix → stop immediately

Why DFS?
- Explore all possible paths from each cell

-----------------------------------------------------

CORE IDEA:

1. Insert all words into Trie
2. Start DFS from each cell in the grid
3. While traversing:
   - Follow Trie path
   - If no Trie child exists → stop early (pruning)
   - If we reach a word → add to result

-----------------------------------------------------

IMPORTANT DESIGN CHOICES:

1. Store full word in Trie node:
   - Avoid rebuilding string during DFS
   - Directly add word when found

2. Mark visited using '#':
   - Avoid extra visited array
   - Restore after DFS (backtracking)

3. Set word = null after adding:
   - Avoid duplicates

-----------------------------------------------------

EDGE CASES HANDLED:

1. Empty board → loops won't run → return []
2. Words not present → never added → return []
3. Same word multiple times in board → added only once
4. Shared prefixes → handled efficiently by Trie
5. Revisiting same cell → prevented using '#'

-----------------------------------------------------

TIME COMPLEXITY:

Worst case:
O(M * N * 4^L)

But significantly optimized due to:
    Trie pruning (cuts branches early)

-----------------------------------------------------

SPACE COMPLEXITY:

O(total characters in words) → Trie
O(L) → recursion stack

-----------------------------------------------------
*/

class Solution {

    // Trie Node definition
    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // 26 lowercase letters
        String word = null; // stores complete word when this node is end of a word
    }

    // Build Trie from all words
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode curr = root;

            for (char c : word.toCharArray()) {
                int idx = c - 'a';

                // Create node if not present
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }

                curr = curr.children[idx];
            }

            // Mark end of word
            curr.word = word;
        }

        return root;
    }

    public List<String> findWords(char[][] grid, String[] words) {

        // Step 1: Build Trie
        TrieNode root = buildTrie(words);

        List<String> res = new ArrayList<>();

        // Step 2: Start DFS from each cell
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dfs(grid, i, j, root, res);
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int row, int col, TrieNode curr, List<String> res) {

        // Boundary check
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        char c = grid[row][col];

        // Stop if:
        // 1. Already visited in this path ('#')
        // 2. No matching child in Trie → prefix invalid
        if (c == '#' || curr.children[c - 'a'] == null) {
            return;
        }

        // Move to next Trie node
        TrieNode next = curr.children[c - 'a'];

        // If a complete word is found
        if (next.word != null) {
            res.add(next.word);

            // Prevent duplicate results
            next.word = null;
        }

        // Mark current cell as visited
        grid[row][col] = '#';

        // Explore all 4 directions
        dfs(grid, row + 1, col, next, res);
        dfs(grid, row - 1, col, next, res);
        dfs(grid, row, col + 1, next, res);
        dfs(grid, row, col - 1, next, res);

        // Backtrack: restore original character
        grid[row][col] = c;
    }
}