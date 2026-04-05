class Solution {

    /*
    INTUITION:
    We need to generate all valid combinations of parentheses.

    Example for n = 2:
        ()()
        (())

    Total parentheses = n * 2

    ------------------------------------------------------------

    THINK LIKE THIS:

    We are building the string step by step.

    At every step, we have 2 choices:
        1. Add '('
        2. Add ')'

    BUT we cannot add them freely.
    We must follow rules to keep it valid.

    ------------------------------------------------------------

    RULES:

    1. We can add '(' only if we still have some left:
            open < n

    2. We can add ')' only if it won't break the string:
            close < open

       Why?
       Because we cannot close more brackets than we opened.

       Example of invalid:
            ")("   ❌
            "())(" ❌

    ------------------------------------------------------------

    GOAL:

    When string length becomes n * 2,
    it means we used all parentheses → valid answer

    ------------------------------------------------------------

    HOW THIS WORKS:

    We explore all valid paths using recursion (DFS).

    Think of it like a tree:
        ""
       /   \
     "("   (invalid)
     / \
   "((" "()"
    ...

    We only follow valid paths → no need to check validity later
    */

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        // Start DFS with:
        // open = 0, close = 0, empty string
        dfs(res, 0, 0, "", n);

        return res;
    }

    private void dfs(List<String> res, int open, int close, String s, int n) {

        // If the string is complete, add to result
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        // OPTION 1: Add '(' if we still have some left
        if (open < n) {
            dfs(res, open + 1, close, s + "(", n);
        }

        // OPTION 2: Add ')' only if it is valid
        if (close < open) {
            dfs(res, open, close + 1, s + ")", n);
        }
    }
}