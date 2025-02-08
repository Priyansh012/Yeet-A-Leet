class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        queue.add(t);
        // Remove all pings that are older than t - 3000
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
