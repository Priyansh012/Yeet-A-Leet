//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node zero= new Node(0);
        Node one = new Node(0);
        Node two = new Node(0);
        
        Node zeroPtr=zero, onePtr=one, twoPtr=two;
        Node traverse=head;
        
        while(traverse!=null){
            
            if(traverse.data==0){
                zeroPtr.next=traverse;
                zeroPtr= zeroPtr.next;
            }
            
            else if(traverse.data==1){
                onePtr.next=traverse;
                onePtr= onePtr.next;
            }
            
            else{
                twoPtr.next=traverse;
                twoPtr=twoPtr.next;
            }
            
            traverse=traverse.next;
        }
        
        zeroPtr.next= (one.next!=null)? one.next: two.next;
        
        onePtr.next = two.next;
        
        twoPtr.next=null;
        
        return zero.next;
    }
}


