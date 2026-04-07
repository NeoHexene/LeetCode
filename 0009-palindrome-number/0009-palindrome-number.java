class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x == 0)
            return true;
        int temp = x;
        int n = 0;
        while (temp != 0) {
            int units = temp % 10;
            n = (n * 10) + units;
            temp = temp / 10;
        }
        return n == x;

    }
}