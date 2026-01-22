class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int n = c1.length;
        boolean f1 = helper(c1, c2, n);
        boolean f2 = helper(c2, c1, n);
        return f1 || f2;
    }

    private boolean helper (char[] arr1, char[] arr2, int n) {
        for (int i = n - 1; i>=0; i--) {
            if(arr1[i] < arr2[i]) {
                return false;
            }
        }
        return true;
    }
}