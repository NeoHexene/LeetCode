class Solution {
    public boolean canReach(int[] start, int[] target) {
        int st = start[0] + start[1]; // if even then black else white
        int tt = target[0] + target[1]; // if even then black else white

        /* 

        2 and half steps will always land black to white in odd steps and black to black in even steps
        hence if the color of start and target both are same then its even number of steps else odd
        
        */

        return st % 2 == tt % 2;
    }
}