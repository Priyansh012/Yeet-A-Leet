class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n=prerequisites.length;
        int  inDegree [] = new int [numCourses]; 
        Queue<Integer> q = new LinkedList<Integer>();
        int topoSort [] = new int[numCourses];
        int count=0;

        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
            
        //create adjList of the graph of courses
        for(int i=0;i<n;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        //fill indegree of each nodes
        for(int i=0;i<numCourses;i++){
            for(int neighbor: adj.get(i)){
                inDegree[neighbor]++;
            }
        }
        
        //add all the nodes in q with inDegree as 0
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0)
                q.add(i);
        }
        
        //bfs, pop the top node of q and traverse its neighbors
        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            topoSort[i++]=node;
            for(int neighbor: adj.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0)
                    q.add(neighbor);
            }
        }

        //if toposort contains all the courses 
        //then we can finish all coruses. return true else return false
        if(count==numCourses)
            return topoSort;
        
        return new int[0];
    }
}