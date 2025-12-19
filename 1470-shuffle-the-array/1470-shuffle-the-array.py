class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        ans = []
        midIdx = n
        startIdx = 0
        temp = n

        while temp > 0:
            ans.append(nums[startIdx])
            ans.append(nums[midIdx])
            temp -= 1
            startIdx += 1
            midIdx += 1

        return ans