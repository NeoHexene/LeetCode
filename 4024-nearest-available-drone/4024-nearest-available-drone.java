class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        
        int minIdx = drones.length + 1;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < drones.length; i++) {
            
            int curr[] = drones[i];
            int temp = Math.abs(curr[0] - target[0]) + Math.abs(curr[1] - target[1]);
            if (temp <= curr[2] && temp < minDist) {
                minDist = temp;
                minIdx = i;
            }
        }

        return minIdx == drones.length + 1 ? -1 : minIdx;
    }
}