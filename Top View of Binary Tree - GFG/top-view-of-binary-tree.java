//{ Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Tuple{
    Node node;
    
    //row to indicate the vertical
    int row;
    
    public Tuple(Node _node, int _row){
        node= _node;
        row= _row;
    }
} 


class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        
        ArrayList<Integer> result= new ArrayList<Integer>();
        if(root ==null)
            return result;
        
        //TreeMap to store nodes in the verticals in sorted order
        Map<Integer, Integer> nodesMap = new TreeMap<Integer, Integer>();
        
        //This queue is to store the order of traversals(level order traversal)
        Queue<Tuple> q = new LinkedList<Tuple>();
        
        q.add(new Tuple(root, 0));
        
        while(!q.isEmpty()){
            // remove first inserted element from queue and do level order traversal
            Tuple tuple = q.remove();
            Node node= tuple.node;
            int vertical= tuple.row;
            
            if(nodesMap.get(vertical)==null)
                nodesMap.put(vertical,node.data);
            
            //if current node has left element then add it into the traversal queue
            if(node.left!=null)
                q.add(new Tuple(node.left, vertical-1));
            
            //if current node has right element then add it into the traversal queue
            if(node.right!=null)
                q.add(new Tuple(node.right, vertical+1));
        }
        
        for(Map.Entry<Integer, Integer> entry : nodesMap.entrySet()){
            result.add(entry.getValue());
        }
        
        return result;
    }
}