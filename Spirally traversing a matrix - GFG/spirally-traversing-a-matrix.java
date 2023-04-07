//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int top=0, down=r-1, left=0, right=c-1;
        int direction=0;
        while(top<=down && left<=right){
            if(direction==0){
                for(int i=left;i<=right;i++){
                    result.add(matrix[top][i]);
                }
                top+=1;
            }
            
            else if(direction==1){
                for(int i=top;i<=down;i++){
                    result.add(matrix[i][right]);
                }
                right-=1;
            }
            
            else if(direction==2){
                for(int i=right;i>=left;i--){
                    result.add(matrix[down][i]);
                }
                down-=1;
            }
            
            else if(direction==3){
                for(int i=down;i>=top;i--){
                    result.add(matrix[i][left]);
                }
                left+=1;
            }
            
            direction=(direction+1)%4;
        }
        
        return result;
    }
}
