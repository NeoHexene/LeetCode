class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int curr = 0; curr < numRows; curr++) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < curr + 1; i++) {
                if (i == 0 || i == curr) {
                    temp.add(1);
                } else {
                    temp.add(res.get(curr - 1).get(i - 1) + res.get(curr - 1).get(i));
                }
            }
            res.add(temp);
        }

        return res;
    }
}