class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        sum = 0
        maxSum = 0
        for n in nums:
            if n == 0:
                sum = 0
            else:
                sum += n
            maxSum = max(sum, maxSum)
            
        return maxSum