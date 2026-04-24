class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0, b = 0;

        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'L') {
                l += 1;
            } else if (c == 'R') {
                r += 1;
            } else {
                b += 1;
            }
        }

        if (l > r) {
            return (l + b) - r;
        } else {
            return (r + b) - l;
        }
    }
}