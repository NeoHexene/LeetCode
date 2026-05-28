class Solution {
    public int passwordStrength(String password) {
        boolean[] ch = new boolean[257];
        int count = 0;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (ch[c]) {
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                count += 1;
            } else if (c >= 'A' && c <= 'Z') {
                count += 2;
            } else if (c >= '0' && c <= '9') {
                count += 3;
            } else {
                count += 5;
            }
            ch[c] = true;
        }
        return count;
    }
}