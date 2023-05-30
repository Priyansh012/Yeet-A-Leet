class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int vis [][]= new int [m][n];
        int deltaRow [] = {-1, 0, +1, 0};
        int deltaCol [] = {0, +1, 0, -1};

        //traverse boundaries to mark Os and its neighbors as visited so that it cannot be flipped to Xs
        //traverse rows(i.e go to all cols of first and last row)
        for(int j=0;j<n;j++){
            //first row
            if(vis[0][j]==0 && board[0][j]=='O')
                dfs(0, j, vis, board, deltaRow, deltaCol, m, n);

            //last row
            if(vis[m-1][j]==0 && board[m-1][j]=='O')
                dfs(m-1, j, vis, board, deltaRow, deltaCol, m, n);
        }

        //traverse cols(i.e go to rows of first and last col)
        for(int i=0;i<m;i++){
            //first col
            if(vis[i][0]==0 && board[i][0]=='O')
                dfs(i, 0, vis, board, deltaRow, deltaCol, m, n);
            
            //first row
            if(vis[i][n-1]==0 && board[i][n-1]=='O')
                dfs(i, n-1, vis, board, deltaRow, deltaCol, m, n);
        }

        //flip rest of the 0s to Xs since they are surrounded by Xs
        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(board[i][j]=='O' && vis[i][j]==0)
                    board[i][j]='X';
            }
        }

    }

    private void dfs(int row,int col, int vis [][], 
    char board [][], int deltaRow[], int deltaCol[], int m, int n){
        vis[row][col]=1;

        for(int i=0;i<4;i++){
            int nRow=row+deltaRow[i];
            int nCol=col+deltaCol[i];

            if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && vis[nRow][nCol]==0 && board[nRow][nCol]=='O'){
                dfs(nRow, nCol, vis, board, deltaRow, deltaCol, m, n);
            }
        }
    }
}