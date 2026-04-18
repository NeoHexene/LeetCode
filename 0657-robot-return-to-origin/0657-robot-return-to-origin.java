class Solution {
    public boolean judgeCircle(String moves) {
        int vertical = 0 , horizontal = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch(moves.charAt(i)) {
                case 'U': {
                    vertical++;
                    break;
                }
                case 'L': {
                    horizontal--;
                    break;
                }
                case 'D': {
                    vertical--;
                    break;
                }
                case 'R': {
                    horizontal++;
                }
            }
        }
        return vertical == 0 && horizontal == 0;
    }
}