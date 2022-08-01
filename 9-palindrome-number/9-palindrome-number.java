class Solution {
    public boolean isPalindrome(int x) {
        int b, sum = 0;
        int a = x;
        if (x<0) {
            return false;
        }
        while (a!=0) {
            b = a%10;
            a = a/10;
            sum = sum*10 +b;
        }
        if (sum == x) {
            return true;
        }
        else {
            return false;
        }
    }
}