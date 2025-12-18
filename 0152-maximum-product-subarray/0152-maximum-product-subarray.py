class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = max(nums)
        currMax, currMin = 1, 1

        for n in nums:
            if n == 0:
                currMax, currMin = 1, 1
                continue
            tempMax = currMax * n
            tempMin = currMin * n
            currMax = max(tempMax, tempMin, n)
            currMin = min(tempMax, tempMin, n)
            res = max(currMax, res)

        return res
        