class RideSharingSystem {

    Deque<Integer> rider = null;
    Deque<Integer> driver = null;
    
    public RideSharingSystem() {
        rider = new LinkedList<>();
        driver = new LinkedList<>();
    }
    
    public void addRider(int riderId) {
        rider.addLast(riderId);
    }
    
    public void addDriver(int driverId) {
        driver.addLast(driverId);
    }
    
    public int[] matchDriverWithRider() {
        if (!rider.isEmpty() && !driver.isEmpty()) {
            return new int[]{driver.pollFirst(), rider.pollFirst()};
        } else {
            return new int[]{-1, -1};
        }
    }
    
    public void cancelRider(int riderId) {
        Iterator<Integer> itr = rider.iterator();
        while (itr.hasNext()) {
            if (itr.next() == riderId) {
                itr.remove();
                break;
            }
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */