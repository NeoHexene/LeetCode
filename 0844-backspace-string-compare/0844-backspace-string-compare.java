class Solution {
    public boolean backspaceCompare(String s, String t) {
        int idx = -1;
        StringBuilder sbs = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (idx > -1) {
                    sbs.deleteCharAt(idx);
                    idx -= 1;
                }
            } else {
                idx += 1;
                sbs.append(s.charAt(i));
            }
        }

        idx = -1;
        StringBuilder sbt = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == '#') {
                if (idx > -1) {
                    sbt.deleteCharAt(idx);
                    idx -= 1;
                }
            } else {
                idx += 1;
                sbt.append(t.charAt(i));
            }
        }

        return sbs.toString().equals(sbt.toString());
    }
}