class Solution {
    public String longestCommonPrefix(String[] s) {
        int n = s.length;
        String ans;
        int maxlen = s[0].length();
        for (int i = 0; i<n; i++) {
            if (s[i].length()<maxlen) {
                maxlen = s[i].length();
            }
        }
        StringBuilder sb = new StringBuilder();
        char c = ' ';
        int flag = 0;
        int nomatch = 0;
        for (int i = 0; i<maxlen && nomatch == 0; i++) {
            if (n==1) {
                c = s[0].charAt(i);
                sb.append(c);
                flag = 1;
                break;
            }
            int j = 0;
            int count = 0;
            while (j<n-1) {
                if (s[j].charAt(i)==s[j+1].charAt(i)) {
                    count += 1;
                    c = s[j].charAt(i);
                }
                else {
                    nomatch = 1;
                }
                j += 1;
            }
            if (count == n-1) {
                sb.append(c);
                flag = 1;
            }
        }
        if (flag == 1) {
           ans = sb.toString();
        }
        else {
            ans = "";
        }
        return (ans);
    }
}