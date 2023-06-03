class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n=prerequisites.length;
        int  inDegree [] = new int [numCourses]; 
        Queue<Integer> q = new LinkedList<Integer>();
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
        while(!q.isEmpty()){
            int node=q.poll();
            count++;

            for(int neighbor: adj.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0)
                    q.add(neighbor);
            }
        }

        //if toposort contains all the courses 
        //then we can finish all coruses. return true else return false
        if(count==numCourses)
            return true;
        
        return false;
    }
}