class Solution {
    public int captureForts(int[] forts) {
        int lastPol = 0, lastIdx = -1, max = 0;
        
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] != 0) {
                if (lastPol == 0 && lastIdx == -1) {
                    lastPol = forts[i];
                    lastIdx = i;
                } else {
                    if (lastPol == forts[i]) {
                        lastIdx = i;
                    } else {
                        max = Math.max(max, i - lastIdx - 1);
                        lastPol = forts[i];
                        lastIdx = i;
                    }
                }
            }
        }

        return max;
    }
}