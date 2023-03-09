//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            Solution ob = new Solution();
            List<Integer> ans = ob.get(a,b);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //Method 1: Simple Maths
    // static List<Integer> get(int a,int b)
    // {
    //     // code here
    //     a=a+b;
    //     b=Math.abs(a-b);
    //     a=Math.abs(a-b);
    //     List<Integer> list = new ArrayList<>();
    //     list.add(a);
    //     list.add(b);
        
    //     return list;
    // }
    
    //Method 2: Bit Manipulation XOR
        static List<Integer> get(int a, int b){
            a=a^b; //store total sum
            b=b^a;  //b will store a by xor'ing sum with b
            a=a^b; // a will store b by xor'ing sum with a
            
            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
        
            return list;
        }
}