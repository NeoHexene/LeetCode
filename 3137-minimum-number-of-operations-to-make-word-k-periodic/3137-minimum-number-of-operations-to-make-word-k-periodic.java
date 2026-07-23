class Solution {

    private String subString(String s, int i, int j) {
        
        StringBuilder sb = new StringBuilder();
        while (i < j) {
            sb.append(s.charAt(i++));
        }

        return sb.toString();
    }

    public int minimumOperationsToMakeKPeriodic(String s, int k) {

        HashMap<String, Integer> map = new HashMap<>();
        int maxFreq = 0;

        int i = 0, j = k, n = s.length();

        while (i < n) {
            String temp = subString(s, i, j);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(temp));
            i = j;
            j = j + k;
        }

        return (n / k) - maxFreq;

    }
}