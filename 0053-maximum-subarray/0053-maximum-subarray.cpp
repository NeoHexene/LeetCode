class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int currmax = 0;
        int res = INT_MIN;

        for (auto n : nums) {
            currmax = max(n, currmax + n);
            res = max(res, currmax);
        }

        return res;
    }
};