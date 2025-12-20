class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        temp = set(nums)
        n = len(nums)
        i = 1
        ans = []

        while i <= n:
            if i not in temp:
                ans.append(i)
            i+=1

        return ans