class EventManager {

    Map<Integer, Integer> map;
    PriorityQueue<int[]> pq;

    public EventManager(int[][] events) {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {if (a[0] != b[0]) {
            return b[0] - a[0];
        } return a[1] - b[1];});

        for (int[] event : events) {
            map.put(event[0], event[1]);
            pq.offer(new int[]{event[1], event[0]});
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        map.put(eventId, newPriority);
        pq.offer(new int[]{newPriority, eventId});
    }
    
    public int pollHighest() {
        while(!pq.isEmpty()) {
            int curr[] = pq.peek();
            if (map.containsKey(curr[1]) && map.get(curr[1]) == curr[0]) {
                curr = pq.poll();
                map.remove(curr[1]);
                return curr[1];
            }
            pq.poll();
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */