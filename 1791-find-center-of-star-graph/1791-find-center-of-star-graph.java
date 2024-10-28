class Solution {
    public int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<edges.length;i++){
            if(set.add(edges[i][0])==false){
                return edges[i][0];
            }

             if(set.add(edges[i][1])==false){
                return edges[i][1];
            }
        }

        return 0;
    }
}