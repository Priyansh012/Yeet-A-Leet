public class DisjointSet {
	List<Integer> parent = new ArrayList<Integer>();
	List<Integer> size = new ArrayList<Integer>();
	
	public DisjointSet(int n) {
		for(int i=0;i<=n;i++) {
			//initially parent of all nodes will be the nodes themselves
			parent.add(i);
			
			size.add(1);
		}
	}
	
	public int findParent(int node) {
	//base case
		if(node == parent.get(node))
			return node;
		int ultimateParent=findParent(parent.get(node));
		parent.set(node, ultimateParent);
		return parent.get(node);
					
	}
	
	public void unionBySize(int u, int v) {
		int ultimateParentU=findParent(u);
		int ultimateParentV=findParent(v);
		if(ultimateParentU==ultimateParentV)
			return;
		
		if(size.get(ultimateParentU)<size.get(ultimateParentV)) {
			parent.set(ultimateParentU, ultimateParentV);
			size.set(ultimateParentV, size.get(ultimateParentV)+size.get(ultimateParentU));
		}
		
		else {
			parent.set(ultimateParentV, ultimateParentU);
			size.set(ultimateParentU, size.get(ultimateParentV)+size.get(ultimateParentU));
		}
	}
}


class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        //count to use the edges from components which creates cycle i.e
        // those edges even if we remove them from the components, the nodes in that
        //component are still connected
        int countExtras=0;

        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];

            if(ds.findParent(u)==ds.findParent(v))
                countExtras++;
            else
                ds.unionBySize(u,v);
        }

        int connectedComponents=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i)
                connectedComponents++;
        }

        //number of operations = connectedComp -1;

        int ans=connectedComponents-1;
        if(countExtras>=ans)
            return ans;
        
        return -1;

    }
}