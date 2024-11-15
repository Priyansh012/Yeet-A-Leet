class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> cityTravelCount = new HashMap<>();

        for(int i=0;i<paths.size();i++){
            cityTravelCount.put(paths.get(i).get(0), 1);
        }

       for(int i=paths.size()-1; i>=0;i--){
            if(!cityTravelCount.containsKey(paths.get(i).get(1)))
                return paths.get(i).get(1);
        }
       return "";
    }
}