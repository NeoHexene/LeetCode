class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        n = len(nums)
        total = int(n * (n + 1) / 2)
        missing = total - sum(set(nums))
        duplicate = sum(nums) - (total - missing)
        return [duplicate, missing]
        