class Solution {
    public int maxBalancedSubarray(int[] nums) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0,0", -1);
        int currXOR = 0;
        int currBal = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            currXOR ^= num;

            if (num % 2 == 0) {
                currBal ++;
            } else {
                currBal --;
            }

            String s = currXOR + "," + currBal;

            if (map.containsKey(s)) {
                int prevIndex = map.get(s);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(s,i);
            }
            
        }
        return maxLength;
    }
}