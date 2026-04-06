/*
INTUITION:
We need to check if a string of brackets is valid.

A string is valid if:
1. Every opening bracket has a corresponding closing bracket
2. Brackets close in the correct order (LIFO → Last In First Out)

This naturally fits a STACK:
- When we see an opening bracket → push expected closing bracket
- When we see a closing bracket → it must match the top of the stack

-----------------------------------------------------

BRUTE FORCE APPROACH:

- Keep removing valid pairs like "()", "{}", "[]" from the string
- Repeat until no more changes
- If string becomes empty → valid, else invalid

Time Complexity: O(n^2) (due to repeated string operations)  
Space Complexity: O(n)

-----------------------------------------------------

OPTIMIZED APPROACH (USED HERE):

Use a stack:
- Push expected closing brackets instead of opening ones
- When encountering a closing bracket:
    - Check if it matches the top of the stack
    - If not → invalid

Why push closing brackets?
    It simplifies comparison (no need for mapping later)

-----------------------------------------------------

IMPLEMENTED LOGIC:

- Traverse each character:
    - If opening bracket:
        → push corresponding closing bracket
    - Else (closing bracket):
        → if stack empty OR mismatch → return false
- At the end:
    - If stack is empty → valid
    - Else → invalid

-----------------------------------------------------

TIME COMPLEXITY: O(n)

SPACE COMPLEXITY: O(n)
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Traverse each character
        for (char c : s.toCharArray()) {

            // Push expected closing brackets
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket
            else {
                // If stack is empty OR mismatch → invalid
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        // If stack is empty → all brackets matched
        return stack.isEmpty();
    }
}