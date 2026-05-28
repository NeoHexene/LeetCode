class Solution {
    public int passwordStrength(String password) {
        boolean[] lc = new boolean[26];
        boolean[] uc = new boolean[26];
        boolean[] num = new boolean[10];
        Set<Character> set = new HashSet<>();
        
        int count = 0;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isDigit(c) && !num[c - '0']) {
                count += 3;
                num[c - '0'] = true;
            } else {
                if (Character.isLowerCase(c) && !lc[c - 'a']) {
                    count += 1;
                    lc[c - 'a'] = true;
                } else if (Character.isUpperCase(c) && !uc[c - 'A']) {
                    count += 2;
                    uc[c - 'A'] = true;
                } else if ((c == '!' || c == '@' || c == '#' || c == '$') && !set.contains(c)) {
                    count += 5;
                    set.add(c);
                }
            }
            System.out.println("Count: " + count);
        }

        return count;
    }
}