class Solution {
    public String breakPalindrome(String palindrome) {
        return changer(palindrome);
    }

    private String changer (String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length/2; i++) {
            System.out.println("Character: "+c[i]);
            if (c[i] != 'a') {
                c[i] = 'a';
                break;
            }
        }
        String temp = new String(c);
        System.out.println("Temp:"+temp+" s: "+s);
        if (temp.equals(s) && s.length() > 1) {
            c[c.length - 1] = 'b';
            return new String(c);
        }
        if (s.equals(temp)) {
            return "";
        }
        return new String(c);
    }
}