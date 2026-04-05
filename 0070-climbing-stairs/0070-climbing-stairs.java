class Solution {
    
    private Map<Integer, Integer> dp = new HashMap<>();

    public int climbStairs(int n) {
        return recursion(n);
    }

    private int recursion(int n) {
        System.out.println("n: "+n);
        if (n <= 3) {
            return n;
        }
        if (!dp.containsKey(n)) {
            dp.put(n, recursion(n - 1) + recursion(n - 2));
        }

        return dp.get(n);
    }
}