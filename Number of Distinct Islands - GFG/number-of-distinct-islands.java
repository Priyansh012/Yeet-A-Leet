//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]= new int[n][m];
        int deltaRow[]= {-1, 0, +1, 0};
        int deltaCol[]= {0, +1, 0, -1};
        HashSet<ArrayList<String>> st = new HashSet<ArrayList<String>>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    ArrayList<String> vec = new ArrayList<String>();
                    dfs(i, j, grid, vis, deltaRow, deltaCol, vec ,i, j);
                    st.add(vec);
                }
            }
        }
        
        return st.size();
    }
    
    private void dfs(int row, int col, int grid [][], int vis [][], 
    int deltaRow [], int deltaCol[], ArrayList<String> vec,int row0, int col0){
        
        vis[row][col]=1;
        vec.add(toString(row-row0, col-col0));
        int n=grid.length;
        int m=grid[0].length;

        //visit its four neighbors 
        for(int i=0;i<4;i++){
            int nRow=row+deltaRow[i];
            int nCol=col+deltaCol[i];

            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1 && vis[nRow][nCol]==0){
                dfs(nRow, nCol, grid, vis, deltaRow, deltaCol, vec ,row0, col0);
            }
        }

    }
    
    private String toString(int r, int c){
        return Integer.toString(r)+ " " + Integer.toString(c);
    }
}
