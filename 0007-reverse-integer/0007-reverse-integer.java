class Solution {
    /*
    INTUITION:
    We want to reverse the digits of an integer.

    Example:
        123 → 321
        -123 → -321

    Idea:
    - Extract last digit using % 10
    - Build the reversed number step by step

    Process:
        ans = ans * 10 + last_digit

    Keep doing this until x becomes 0.

    Important:
    - The reversed number might overflow int range
    - So we use long to store intermediate result
    - If it goes out of bounds, return 0
    */

    public int reverse(int x) {

        long ans = 0; // use long to detect overflow

        while (x != 0) {

            // Get last digit
            long temp = x % 10;

            // Add digit to reversed number
            ans = ans * 10 + temp;

            // Remove last digit from x
            x = x / 10;
        }

        // Check if result is within integer range
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) ans;
    }
}