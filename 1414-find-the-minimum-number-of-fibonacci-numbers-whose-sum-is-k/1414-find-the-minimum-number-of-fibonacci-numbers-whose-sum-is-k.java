class Solution {
    public int findMinFibonacciNumbers(int k) {
        Stack<Long> fib = new Stack<>();
        fib.push(1L);
        fib.push(1L);
        long prev = 1L;
        long prev_1 = 1L;
        while (prev < (long) k) {
            fib.push(prev_1 + prev);
            long temp = prev_1;
            prev_1 = prev;
            prev = temp + prev;
        }
        int count = 0;
        System.out.println(fib.toString());
        while (k > 0) {
            while(!fib.isEmpty() && fib.peek() > k) {
                fib.pop();
            }
            k -= fib.pop();
            count+=1;
        }
        if (k == 0) {
            return count;
        }
        return -1;
    }
}