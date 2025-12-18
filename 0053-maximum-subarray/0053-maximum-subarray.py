class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res = nums[0]
        currMax = nums[0]

        for n in range(1, len(nums)):
            tempMax = currMax + nums[n]
            currMax = max(tempMax, nums[n])
            res = max(res, currMax)

        return res