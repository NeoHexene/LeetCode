class Solution {
    public String decodeString(String s) {

        /*
        */

        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ']') {
                st.push(""+ch);
            } else {
                StringBuilder sb = new StringBuilder();
                while(!"[".equals(st.peek())) {
                    sb.append(st.pop());
                }
                st.pop();
                StringBuilder digit = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                    digit.append(st.pop());
                }
                int n = Integer.parseInt(digit.reverse().toString());
                String repeated = sb.toString().repeat(n);
                st.push(repeated);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String ele : st) {
            StringBuilder elesb = new StringBuilder(ele);
            sb.append(elesb.reverse());
        }

        return sb.toString();

    }
}