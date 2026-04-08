/*
INTUITION:
We need to compute x^n efficiently.

A brute force way would multiply x by itself n times, but that is too slow.

The key observation is:
- If n is even: x^n = (x * x)^(n / 2)
- If n is odd:  x^n = x * (x * x)^((n - 1) / 2)

So instead of reducing the power by 1 each time, we reduce it by half.
This is called exponentiation by squaring.

-----------------------------------------------------

BRUTE FORCE APPROACH:

Multiply x repeatedly n times.

Time Complexity: O(n)
Space Complexity: O(1)

-----------------------------------------------------

OPTIMIZED APPROACH (USED HERE):

Use recursion and divide the exponent by 2 at each step.

Cases:
1. n == 0 → return 1
2. n < 0  → convert to reciprocal
   x^(-n) = 1 / x^n
3. n is even → square x and halve n
4. n is odd  → take one x outside and solve the rest recursively

-----------------------------------------------------

WHY LONG IS USED:

If n = Integer.MIN_VALUE, then -n overflows int.
So we first convert n to long before negating it.

-----------------------------------------------------

TIME COMPLEXITY:
O(log n)

SPACE COMPLEXITY:
O(log n)
because of recursion stack
*/

class Solution {
    public double myPow(double x, int n) {
        // Convert n to long first to avoid overflow when n = Integer.MIN_VALUE
        return helper(x, (long) n);
    }

    private double helper(double x, long n) {
        // Any number raised to power 0 is 1
        if (n == 0) {
            return 1;
        }

        // Base case for power 1
        if (n == 1) {
            return x;
        }

        // Handle negative powers:
        // x^-n = 1 / x^n
        if (n < 0) {
            return 1 / helper(x, -n);
        }

        // If exponent is even:
        // x^n = (x*x)^(n/2)
        if (n % 2 == 0) {
            return helper(x * x, n / 2);
        }

        // If exponent is odd:
        // x^n = x * (x*x)^((n-1)/2)
        return x * helper(x * x, (n - 1) / 2);
    }
}