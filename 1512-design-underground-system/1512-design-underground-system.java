class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();
    Map<String, Pair<Double, Integer>> routeMap = new HashMap<>();

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        if (!checkInMap.containsKey(id)) {
            return;
        }
        
        Pair<String, Integer> checkInData = checkInMap.get(id);
        String startStation = checkInData.getKey();
        int startTime = checkInData.getValue();
        int travelTime = t - startTime;
        String route = startStation + "->" + stationName;
        
        if (routeMap.containsKey(route)) {
            Pair<Double, Integer> currentData = routeMap.get(route);
            double totalTime = currentData.getKey() + travelTime;
            int count = currentData.getValue() + 1;
            routeMap.put(route, new Pair<>(totalTime, count));
        } else {
            routeMap.put(route, new Pair<>((double) travelTime, 1));
        }
        
        checkInMap.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        if (routeMap.containsKey(route)) {
            Pair<Double, Integer> data = routeMap.get(route);
            return data.getKey() / data.getValue();
        }
        return 0.0;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */