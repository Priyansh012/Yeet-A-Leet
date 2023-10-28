class DisjointSet{
    List<Integer> parent= new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findParent(int node){
        if(node == parent.get(node))
            return node;
        int ultimateParent=findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }
    
    public void unionBySize(int u, int v){
        int ultimateParentU=findParent(u);
		int ultimateParentV=findParent(v);
		if(ultimateParentU==ultimateParentV)
			return;
        
        if(size.get(ultimateParentU)>size.get(ultimateParentV)){
            parent.set(ultimateParentV, ultimateParentU);
			size.set(ultimateParentU, size.get(ultimateParentV)+size.get(ultimateParentU));
        }
        
        else{
            parent.set(ultimateParentU, ultimateParentV);
            size.set(ultimateParentV, size.get(ultimateParentU)+size.get(ultimateParentV));
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int maxRow=0;
        int maxCol=0;
        
        for(int i=0;i<stones.length;i++){
            maxRow= Math.max(maxRow, stones[i][0]);
            maxCol= Math.max(maxCol, stones[i][1]);
        }
        
        DisjointSet ds = new DisjointSet(maxRow+maxCol+1);
        Map<Integer, Integer> stoneNodes = new HashMap<>();
        for(int i=0;i<stones.length;i++){
            int nodeRow= stones[i][0];
            //this is done because we are using the same disjoint set to store row stones and col stones
            //so the col stones will be stored right after the row stones finishes in the disjoint set
            int nodeCol= stones[i][1]+maxRow+1;
            
            ds.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeCol, 1);
            stoneNodes.put(nodeRow, 1);
        }
        
        int count=0;
        for(Map.Entry<Integer, Integer> it : stoneNodes.entrySet()){
            if(ds.findParent(it.getKey())== it.getKey()){
                count++;
            }       
        }
        
        return stones.length-count;
    }
}