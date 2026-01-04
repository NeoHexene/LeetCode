class Solution {
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            double cubeRoot = Math.cbrt(n);
            if (cubeRoot % 1 == 0) {
                int cubeRt = (int) cubeRoot;
                if (isPrime(cubeRt)) {
                    sum += 1 + cubeRt + (cubeRt * cubeRt) + n;
                    continue;
                }
            }
            int squareRoot = (int) Math.sqrt(n);
            for (int i = 2; i <= squareRoot; i++) {
                if (n % i == 0) {
                    int j = n / i;
                    if (isPrime(j) && isPrime(i) && i != j) {
                        sum += 1 + i + j + n;
                        break;
                    }
                }
            }
        }
        return sum;
    }
}