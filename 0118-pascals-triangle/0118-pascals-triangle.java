class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            res.add(new ArrayList<>());
            if (i == 0) {
                res.get(i).add(1);
            }
            if (i == 1) {
                res.get(i).add(1);
                res.get(i).add(1);
            }
        }

        for (int curr = 2; curr < numRows; curr++) {
            for (int i = 0; i < curr + 1; i++) {
                if (i == 0 || i == curr) {
                    res.get(curr).add(1);
                    continue;
                }
                res.get(curr).add(res.get(curr - 1).get(i - 1) + res.get(curr - 1).get(i));
            }
        }

        return res;
    }
}