class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int ele = 0;
        int count = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                ele = nums[i];
                count = 1;
            } else if (ele == nums[i]) {
                count += 1;
            } else {
                count -= 1;
            }
        }

        return ele;
    }
};