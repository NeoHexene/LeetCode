class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasReq = 0, gasAvai = 0;
        for (int i = 0; i < gas.length; i++) {
            gasAvai += gas[i];
            gasReq += cost[i];
        }
        if (gasReq > gasAvai) {
            return -1;
        }
        int res = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            System.out.println("Total: " + total);
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
            System.out.println("Total: " + total);
            System.out.println("Res: " + res);
        }
        return res;
    }
}