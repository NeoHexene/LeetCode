class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        n = len(prices)
        ans = []
        for i in range (0, n):
            discount = False
            for j in range (i+1, n):
                if prices[i] >= prices[j]:
                    ans.append(prices[i] - prices[j])
                    discount = True
                    break
            if not discount:
                ans.append(prices[i])
        return ans