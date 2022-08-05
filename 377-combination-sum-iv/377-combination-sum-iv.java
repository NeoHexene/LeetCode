class Solution {
    public int combinationSum4(int[] nums, int target) {
        // first we create an array for the outout
        int ans [] = new int [target+1]; // size of array is value(target) + 1, since we assume element at index 0 of ans as 1
        ans[0] = 1;
    
        for (int i = 1; i <= target; i++) {
            // for-each loop
            for (int j : nums) { // j will take values of the elements present in nums[]
                if ( j <= i) { // check whether j is less than i or not. if less, then true
                    ans[i] = ans[i] + ans[i-j]; // Eg: i = 1 and j = 1 then ans[1] will be ans[1] + ans[0](i.e 1)
                }
            }
        }
        return ans[target];
    }
}