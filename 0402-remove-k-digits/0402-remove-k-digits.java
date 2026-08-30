class Solution {

    public String removeKdigits(String num, int k) {

        if (k >= num.length()) {
            return "0";
        }
        
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {

            int n = num.charAt(i) - '0';
            while (!st.isEmpty() && k > 0 && st.peek() > n) {
                st.pop();
                k--;
            }

            st.push(n);
        }

        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

        char[] ch = new char[st.size()];
        int i = st.size() - 1;

        while (!st.isEmpty()) {
            ch[i--] = (char) (st.pop() + '0');
        }

        String temp = new String(ch);
        i = 0;

        while (i < temp.length() && temp.charAt(i) == '0') {
            i++;
        }

        return i == temp.length() ? "0" : temp.substring(i, temp.length());
    }
}