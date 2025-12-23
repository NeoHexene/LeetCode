class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int res[] = new int [n];
        Stack<Integer> st = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            int p1 = log.indexOf(":");
            int p2 = log.indexOf(":", p1 + 1);
            int time = Integer.parseInt(log.substring(p2 + 1));
            boolean start = log.charAt(p1 + 1) == 's';
            int id = Integer.parseInt(log.substring(0, p1));

            if (start) {
                if (!st.isEmpty()) {
                    res[st.peek()] += time - prevTime;
                }
                st.push(id);
                prevTime = time;
            } else {
                res[st.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }

        return res;
    }
}