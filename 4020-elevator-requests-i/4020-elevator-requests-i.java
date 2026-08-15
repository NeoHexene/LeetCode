class Solution {
    public int elevatorRequests(int n, int[] requests) {
        
        int curr = 0, total = 0;

        for (int i = 0; i < requests.length; i++) {
            total += Math.abs(curr - requests[i]);
            curr = requests[i];
        }

        return total;
    }
}