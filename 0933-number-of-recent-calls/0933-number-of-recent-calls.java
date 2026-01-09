class RecentCounter {

    ArrayList<Integer> res = new ArrayList<>();

    public RecentCounter() {
        this.res = new ArrayList<>();
    }
    
    public int ping(int t) {
        this.res.add(t);
        int count = 0;
        for (int i : res) {
            if (t - 3000 <= i && t >= i) {
                count += 1;
            }
        }
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */