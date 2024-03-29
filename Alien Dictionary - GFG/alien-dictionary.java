//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

//by BFS Kahn's also
class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {   
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int inDegree [] = new int[K];
        //k is the number of starting letters from the standard dict
        //0->a
        //1->b ... till k number of letters
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        
        //n is the number of strings in alien dict
        //so lets go till n-1 for comparing two strings in alien dict
        //once the first nonmatching char is found between two sorted words in alien dict
        for(int i=0;i<N-1;i++){
            String s1=dict[i];
            String s2=dict[i+1];
            int len=Math.min(s1.length(),s2.length());
            for(int ptr=0;ptr<len;ptr++){
                if(s1.charAt(ptr)!=s2.charAt(ptr)){
                    //mark an edge in the directed graph from s1.charAt(ptr)->s2.charAt(ptr)
                    //but since we create graph with numbers so convert it to numbers from chars
                    adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    break;
                }
            }
        }
        
        //now the DAG is ready, so just do plain topoSort
        
       ArrayList<Integer> topoSort = topoSort(K,adj);
        StringBuilder ans= new StringBuilder();
        for(int i=0;i<K;i++){
            //convert numbers to ASCII value
            ans.append((char)(topoSort.get(i)+(int)'a'));
        }
        
        return ans.toString();
    }
    
    
    static ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int  inDegree [] = new int [V]; 
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> sortedResult = new ArrayList<Integer>();
        
        //fill indegree of each nodes
        for(int i=0;i<V;i++){
            for(int neighbor: adj.get(i)){
                inDegree[neighbor]++;
            }
        }
        
        //add all the nodes in q with inDegree as 0
        for(int i=0;i<V;i++){
            if(inDegree[i]==0)
                q.add(i);
        }
        
        
        //bfs, pop the top node of q and traverse its neighbors
        while(!q.isEmpty()){
            int node=q.poll();
            sortedResult.add(node);
            
            for(int neighbor: adj.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0)
                    q.add(neighbor);
            }
        }
        
        
        return sortedResult;
    }
    
    
}