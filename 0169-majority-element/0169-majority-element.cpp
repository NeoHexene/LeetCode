class Solution {
public:
    int majorityElement(vector<int>& nums) {
        map<int, int> map;
        for (int i = 0; i < nums.size(); i++) {
            map[nums[i]] += 1;
        }
        int maxFreq = 0;
        int max = 0;
        for (auto key : map) {
            if (key.second > maxFreq) {
                maxFreq = key.second;
                max = key.first;
            }
        }
        return max;
    }
};