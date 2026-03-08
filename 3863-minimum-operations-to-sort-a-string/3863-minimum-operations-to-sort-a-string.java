class Solution {
    public int minOperations(String s) {
        if (s.length() == 1) {
            return 0;
        }
        if (s.length() == 2) {
            if (s.charAt(0) > s.charAt(1)) {
                return -1;
            }
            return 0;
        }
        int idx = sortCheck(s);
        if (idx != -1) {
            int backCount = looping (s, false);
            int frontCount = looping (s, true);
            return Math.min(backCount, frontCount);
        }
        return 0;
    }

    private String backSorted (String s) {
        char[] backArray = s.substring(1, s.length()).toCharArray();
        Arrays.sort(backArray);
        return s.charAt(0) + String.valueOf(backArray);
    }

    private String frontSorted (String s) {
        char[] frontArray = s.substring(0, s.length() - 1).toCharArray();
        Arrays.sort(frontArray);
        return String.valueOf(frontArray) + s.charAt(s.length() - 1);
    }

    private int sortCheck (String s) {
        boolean sortReq = false;
        int idx = -1;
        for (int i = 1; i < s.length() && !sortReq; i++) {
            if (!(s.charAt(i - 1) <= s.charAt(i))) {
                idx = i;
                sortReq = true;
            }
        }
        return idx;
    }

    private int looping (String s, boolean front) {
        int count = 0;
        while (sortCheck(s) != -1) {
            if (!front) {
                s = backSorted(s);
            } else {
                s = frontSorted(s);
            }
            front = !front;
            count += 1;
            System.out.println("S: "+s);
        }
        return count;
    }
}