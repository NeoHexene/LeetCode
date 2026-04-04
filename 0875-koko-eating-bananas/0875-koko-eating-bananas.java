class Solution {

    /*
    INTUITION:

    We are not asked to simulate eating bananas directly.
    Instead, we are asked to find the minimum eating speed (k)
    such that Koko can finish all piles within h hours.

    Key observation:
    - If Koko eats slowly, it may take more than h hours.
    - If Koko eats faster, it will definitely finish within h hours.

    This creates a monotonic behavior:
        speed too small  -> cannot finish
        speed large enough -> can finish

    Because of this monotonic pattern, we can use binary search
    on the answer (the eating speed).

    Search space:
    - Minimum possible speed = 1
    - Maximum possible speed = max(piles)

    For each candidate speed, we check:
    "If Koko eats at this speed, can she finish within h hours?"

    If yes:
        try a smaller speed (move right = mid)
    If no:
        need a larger speed (move left = mid + 1)

    Final answer is the smallest valid speed.
    */

    public int minEatingSpeed(int[] piles, int h) {

        // Find the maximum pile size to define the upper bound
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // Minimum possible speed is 1
        int left = 1;

        // Binary search for the smallest valid speed
        while (left < right) {

            int mid = left + (right - left) / 2;

            // Check if Koko can finish with speed = mid
            if (canFinish(piles, mid, h)) {
                // If she can finish, try to minimize speed
                right = mid;
            } else {
                // If she cannot finish, increase speed
                left = mid + 1;
            }
        }

        // left will be the minimum valid speed
        return left;
    }

    /*
    This function checks whether Koko can finish all piles
    within h hours if she eats at speed t.
    */
    private boolean canFinish(int[] piles, int t, int h) {

        int hours = 0;

        for (int pile : piles) {

            // Number of hours needed for this pile:
            // ceil(pile / t)
            hours += pile / t;

            if (pile % t != 0) {
                hours += 1;
            }

            // Early exit if already exceeding allowed hours
            if (hours > h) {
                return false;
            }
        }

        return true;
    }
}