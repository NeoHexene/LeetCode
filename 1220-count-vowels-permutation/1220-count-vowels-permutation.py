class Solution(object):
    def countVowelPermutation(self, n):
        """
        :type n: int
        :rtype: int
        """
        # initialize all vowels counts to 1
		# This is n==1 case
        a, e, i, o, u = 1, 1, 1, 1, 1

        for _ in range(2, n + 1):
            a, e, i, o, u = e + i + u, a + i, e + o, i, i + o

        return (a + e + i + o + u) % (10**9+7)