class Solution {
    public int poorPigs(int buckets, int timedie, int timetest) {
        int t = timetest/timedie;
        int c = 0;
        while (Math.pow((t+1),c)<buckets){
            c++;
        }
        return c;
    }
}