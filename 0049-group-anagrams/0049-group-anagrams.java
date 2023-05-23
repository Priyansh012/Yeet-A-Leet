class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        HashMap<String, List<String>> map= new HashMap<String, List<String>>();
        char arr [];
        String sortedString;
        for(int i=0;i<n;i++){
            arr=strs[i].toCharArray();
            Arrays.sort(arr);
            sortedString= String.valueOf(arr);
            if(map.containsKey(sortedString))
                map.get(sortedString).add(strs[i]);
            else{
                List<String> similarString = new ArrayList<>();
                similarString.add(strs[i]); 
                map.put(sortedString, similarString);                              
            }
        }

        return new ArrayList<> (map.values());
    }
}