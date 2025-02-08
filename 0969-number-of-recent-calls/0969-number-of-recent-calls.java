class RecentCounter {
    List<Integer> list;
    public RecentCounter() {
        list= new ArrayList();
    }
    
    public int ping(int t) {
        list.add(t);
        int lower=t-3000;

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next()<lower) {
                iterator.remove();
            }
        }
            
        return list.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */