class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < n) {
            List<Integer> temp = new ArrayList<>();
            for (int i : res) {
                if (2 * i - 1 <= n) {
                    temp.add(2 * i - 1);
                }
            }
            for (int i : res) {
                if (2 * i <= n) {
                    temp.add(2 * i);
                }
            }
            res = temp;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}