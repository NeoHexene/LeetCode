class Solution {
    public int maxDistance(String moves) {
        
        int[] curr = new int[]{0, 0};
        int l = 0, r = 0, u = 0, d = 0;
        int empty = 0;
    
        for (int i = 0; i < moves.length(); i++) {
            switch(moves.charAt(i)) {
                case 'L': curr[0] -= 1;
                    l++;
                    break;
                case 'R': curr[0] += 1;
                    r++;
                    break;
                case 'U': curr[1] += 1;
                    u++;
                    break;
                case 'D': curr[1] -= 1;
                    d++;
                    break;
                default: empty++;
            }
        }

        return (Math.abs(0 - curr[0]) + Math.abs(0 - curr[1])) + empty;
    }
}