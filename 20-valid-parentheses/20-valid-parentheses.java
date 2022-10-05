class Solution {
    public boolean isValid(String s) {
        Stack st = new Stack();
        int n = s.length();
        char[] a = new char[n];
        char top;
        
        for (int i = 0; i<n; i++) {
            a[i] = s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            if (a[i] == '(' || a[i] == '{' || a[i] == '[') {
                st.push(a[i]);
            }
            else {  
                if (st.empty()) {
                    return false;
                }
                    top = (char)st.peek();
                if (a[i] == ')' && top != '(') {
                    return false;
                }
                else if (a[i] == '}' && top != '{') {
                    return false;
                }
                else if (a[i] == ']' && top != '[') {
                    return false;
                }
                st.pop();
            }
        }
        if (st.empty()) {
            return true;
        }
        else {
            return false;
        }
    }
}