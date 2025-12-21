class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        n = len(nums)
        a = [0] * 101
        res =[]
        for i in nums:
            a[i] += 1
        
        for i in range (1, 101):
            a[i] += a[i-1]

        for n in nums:
            if n == 0:
                res.append(0)
            else:
                res.append(a[n - 1])
        
        return res