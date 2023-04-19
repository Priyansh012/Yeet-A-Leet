class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n=names.length;
        TreeMap<Integer,String> tm=new  TreeMap<Integer,String> (Collections.reverseOrder());  
        for(int i=0;i<n;i++){
            tm.put(heights[i],names[i]);
        }
        int count =0;
        for (Map.Entry<Integer,String> entry : tm.entrySet()) {
            names[count]=entry.getValue();
            count++;
        }

        return names;
    }
}