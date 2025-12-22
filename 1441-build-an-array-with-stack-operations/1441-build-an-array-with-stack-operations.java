class Solution {
    public List<String> buildArray(int[] target, int n) {
        int i = 0;
        int series = 1;
        Stack st = new Stack();
        List<String> list = new ArrayList<>();
        while (i < target.length) {
            int t = target[i];
            while (series != t) {
                st.push(series);
                list.add("Push");
                series+=1;
            }
            while (!st.isEmpty()) {
                st.pop();
                list.add("Pop");
            }
            list.add("Push");
            series+=1;
            i++;
        }
        return list;
    }
}