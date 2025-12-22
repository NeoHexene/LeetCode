class Solution {
    
    public int evalRPN(String[] tokens) {
        Stack st = new Stack();
        int result = 0;
        Set<String> operations = new HashSet<>();
        operations.add("+");
        operations.add("*");
        operations.add("/");
        operations.add("-");
        for (String s : tokens) {
            if (!st.isEmpty() && operations.contains(s)) {
                int last = Integer.parseInt(st.pop().toString());
                int first = Integer.parseInt(st.pop().toString());
                if (s.equals("+")) {
                    result = first + last;
                } else if (s.equals("*")) {
                    result = first * last;
                } else if (s.equals("/")) {
                    result = first / last;
                } else {
                    result = first - last;
                }
                st.push(result);
            } else {
                result = Integer.parseInt(s);
                st.push(s);
            }
        }
        return result;
    }

}