class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occ, int frSt, int frEn) {
        Arrays.sort(occ, (a,b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> temp = new ArrayList<>();
        
        int prev[] = occ[0];

        for (int i = 1; i < occ.length; i++) {
            int[] curr = occ[i];
            
            if (prev[1] + 1 >= curr[0]) {
                prev[1] = Math.max(curr[1], prev[1]);
            } else {
                temp.add(List.of(prev[0], prev[1]));
                prev = curr;
            }
        }

        temp.add(List.of(prev[0], prev[1]));

        List<List<Integer>> res = new ArrayList<>();
        
        for (List<Integer> curr : temp) {
            int idx10 = -1;
            int idx20 = -1;
            int idx11 = -1;
            int idx21 = -1;
            if (curr.get(0) >= frSt && frEn >= curr.get(1)) {
                continue;
            } else if (curr.get(0) <= frSt && frEn <= curr.get(1)) {
                idx10 = curr.get(0);
                idx11 = frSt - 1;
                idx20 = frEn + 1;
                idx21 = curr.get(1);
            } else if (curr.get(1)>= frSt && curr.get(1) <= frEn) {
                idx10 = curr.get(0);
                idx11 = frSt - 1;
            } else if (curr.get(0) <= frEn && curr.get(0) >= frSt) {
                idx20 = frEn + 1;
                idx21 = curr.get(1);
            } else {
                res.add(curr);
                continue;
            }

            if (idx10 != -1 && idx11 != -1 && idx10 <= idx11) {
                res.add(List.of(idx10, idx11));
            }
            if (idx20 != -1 && idx21 != -1 && idx20 <= idx21) {
                res.add(List.of(idx20, idx21));
            }
        }

        return res;
    }
}