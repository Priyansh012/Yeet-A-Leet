//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            ArrayList<Integer> res = g.inOrder(root);
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.print("\n");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/* A Binary Tree node

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
   

//Morris Inorder Traversal TC: O(N), SC: O(1) 
//this is called as Binary Threaded Tree where we create a threaded connection between nodes and then remove it 
class Solution {
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        Node cur = root;
        
        while(cur!=null){
            
            //case 1
            if(cur.left==null){
                inorder.add(cur.data);
                cur=cur.right;
            }
            
            else{
                Node prev= cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }
                //case 2
                if(prev.right==null){
                    //thread created
                    prev.right=cur;
                    //normal inorder traversal
                    cur=cur.left;
                }
                
                //case 3
                else{
                    //remove the thread
                    prev.right=null;
                    inorder.add(cur.data);
                    //normal inorder traversal
                    cur=cur.right;
                }
            }
        }
        
        return inorder;
    }
}
