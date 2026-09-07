class Solution {
    
    public int countRotations(String s, int k) {

        int n = s.length();

        String doubled = s + s;

        int score = 0;
        for (int i = 0; i < n - 1; i++) {
            if (doubled.charAt(i) == doubled.charAt(i + 1)) {
                score++;
            }
        }

        int res = 0;

        if (score == k) {
            res++;
        }

        for (int i = 1; i < n; i++) {

            if (doubled.charAt(i - 1) == doubled.charAt(i)) {
                score--;
            }
            
            if (doubled.charAt(i + n - 2) == doubled.charAt(i + n - 1)) {
                score++;
            }

            if (score == k) {
                res++;
            }
        }

        return res;
    }
}