class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        ans = []
        times = 2

        while times > 0:
            for n in nums:
                ans.append(n)
            times -= 1

        return ans

        