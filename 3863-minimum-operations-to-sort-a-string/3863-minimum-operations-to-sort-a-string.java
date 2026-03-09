class Solution {
    public int minOperations(String s) {
        if (s.length() == 1) {
            return 0;
        }

        char[] tarr = s.toCharArray();
        Arrays.sort(tarr);
        String t = new String(tarr);

        if (s.length() == 2 && !s.equals(t)) {
            return -1;
        }
        if (s.length() == 2 && s.equals(t)) {
            return 0;
        }

        if (s.equals(t)) {
            return 0;
        }

        if (s.charAt(0) == t.charAt(0) || s.charAt(s.length() - 1) == t.charAt(t.length() - 1)) {
            return 1;
        } else {
            char[] frontArr = s.substring(0, s.length() - 1).toCharArray();
            Arrays.sort(frontArr);
            String frontSorted = new String(frontArr) + s.charAt(s.length() - 1);
            char[] backArr = frontSorted.substring(1, s.length()).toCharArray();
            Arrays.sort(backArr);
            String backSorted = frontSorted.charAt(0) + new String(backArr);

            if (backSorted.equals(t)) {
                return 2;
            } else {
                backArr = s.substring(1, s.length()).toCharArray();
                Arrays.sort(backArr);
                backSorted = s.charAt(0) + new String(backArr);
                frontArr = backSorted.substring(0, s.length() - 1).toCharArray();
                Arrays.sort(frontArr);
                frontSorted = new String(frontArr) + backSorted.charAt(s.length() - 1);
                if (frontSorted.equals(t)) {
                    return 2;
                }
            }
            return 3;
        }

    }
}