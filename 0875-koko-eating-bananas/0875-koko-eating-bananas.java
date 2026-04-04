class Solution {

    /*
    [3, 6, 7, 11] h = 8
    piles = 4 ( 1 to 11 )

    [30, 11, 23, 4, 20] h = 5
    piles = 5 ( 1 to 30 )

    [30, 11, 23, 4, 20] h = 6
    piles = 5 ( 1 to 30 )

    So basically in every array koko can eat with the speed between 1 to max(piles array)
    From this range we will figure out which number is the least in which koko can finish
    the entire pile
    */


    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        int left = 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int t, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile / t);
            if (pile % t != 0) {
                hours += 1;
            }
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
}