class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initColor = image[sr][sc];
        int ans [] [] = new int [image.length][image[0].length];
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[i].length; j++)
                ans[i][j]=image[i][j];
        }

        int deltaRow [] = {-1, 0, +1, 0};
        int deltaCol [] = {0, +1, 0, -1};

        dfs(sr, sc, ans, image, color, deltaRow, deltaCol, initColor);

        return ans;
    }

    private void dfs (int row, int col, int [][] ans, int [][] image, 
    int newColor, int deltaRow [], int deltaCol [], int oldColor){
        ans[row][col]= newColor;

        int m= image.length;
        int n= image[0].length;

        //call dfs for neighbors (top, right, bottom, left)
        for(int i=0;i<4;i++){
            int neighRow= row+deltaRow[i];
            int neighCol= col+deltaCol[i];

            //check for valid neighbor
            if(neighRow>=0 && neighRow<m && neighCol>=0 && neighCol<n 
            && image[neighRow][neighCol]==oldColor && ans[neighRow][neighCol]!=newColor){
                dfs(neighRow, neighCol, ans, image, newColor, deltaRow, deltaCol, oldColor);
            }
        }
    }
}