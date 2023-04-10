//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

//Stesp for boundary traversal of a binary tree
//add left boundary(excluding leaf nodes)
//add leaf nodes
//add right boundary in reverse(excluding leaf nodes)

class Solution
{
    boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }
    
    void addLeftBoundary(Node root, ArrayList<Integer> result){
        Node cur=root.left;
        while(cur!=null){
            if(isLeaf(cur) == false)
                result.add(cur.data);
            if(cur.left!=null)
                cur=cur.left;
            else
                cur=cur.right;
        }
    }
    
    void addRightBoundary(Node root, ArrayList<Integer> result){
        Node cur=root.right;
        Stack<Integer> stack = new Stack<Integer>();
        while(cur!=null){
            if(isLeaf(cur)==false)
                stack.add(cur.data);
            if(cur.right!=null)
                cur=cur.right;
            else
                cur=cur.left;
        }
        
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
    }
    
    void addLeaves(Node root, ArrayList<Integer> result){
        if(isLeaf(root) == true)
            result.add(root.data);
        
        if(root.left!=null)
            addLeaves(root.left,result);
        if(root.right!=null)
            addLeaves(root.right,result);
    }
    
	ArrayList <Integer> boundary(Node root)
	{
	    ArrayList <Integer> result = new ArrayList<Integer>();
	    if(root == null)
	        return result;
	    if(isLeaf(root) == false)
	        result.add(root.data);
	    addLeftBoundary(root, result);
	    addLeaves(root,result);
	    addRightBoundary(root, result);
	    return result;
	}
}
