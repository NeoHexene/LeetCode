class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cand1 = 0, cand2 = 0;
        int count1 = 0, count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == cand1) {
                count1 += 1;
            } else if (nums[i] == cand2) {
                count2 += 1;
            } else if (count1 == 0) {
                cand1 = nums[i];
                count1 += 1;
            } else if (count2 == 0) {
                cand2 = nums[i];
                count2 += 1;
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == cand1) {
                count1 += 1;
            } else if (nums[i] == cand2) {
                count2 += 1;
            }
        }

        List<Integer> res = new ArrayList<>();

        if (count1 > nums.length / 3) {
            res.add(cand1);
        }
        if (count2 > nums.length / 3) {
            res.add(cand2);
        }

        return res;
    }
}