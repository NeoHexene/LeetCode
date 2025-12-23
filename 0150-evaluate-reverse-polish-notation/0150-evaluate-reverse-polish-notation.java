class Solution {
    
    public int evalRPN(String[] tokens) {
        Stack st = new Stack();
        Set<String> operations = new HashSet<>();
        operations.add("+");
        operations.add("*");
        operations.add("/");
        operations.add("-");
        for (String s : tokens) {
            if (operations.contains(s)) {
                int last = Integer.parseInt(st.pop().toString());
                int first = Integer.parseInt(st.pop().toString());
                int result = 0;
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
                st.push(s);
            }
        }
        return Integer.parseInt(st.pop().toString());
    }

}