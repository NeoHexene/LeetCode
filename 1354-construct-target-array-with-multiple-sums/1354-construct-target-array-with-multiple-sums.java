class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int t : target) {
            pq.add(t);
            sum += t;
        }

        while (true) {
            int curr = pq.poll();
            long res = sum - curr;
            if (curr == 1 || res == 1) {
                return true;
            }
            if (res >= curr || res == 0) {
                return false;
            }
            long temp = curr % res;
            if (temp == 0) {
                temp = res;
            }
            sum = res + temp;
            pq.offer((int)temp);
        }
    }
}