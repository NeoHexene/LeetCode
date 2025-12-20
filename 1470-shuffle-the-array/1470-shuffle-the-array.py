class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        ans = []
        startIdx = 0

        while startIdx < n:
            ans.append(nums[startIdx])
            ans.append(nums[startIdx + n])
            startIdx += 1

        return ans