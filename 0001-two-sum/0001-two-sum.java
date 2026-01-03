class Solution {
    public int[] twoSum(int[] a, int sum) {
        int n = a.length;
        for (int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                if (a[j] == (sum - a[i])) {
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }   
}