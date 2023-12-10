class Solution {
    //Bruteforce
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean visited [][]= new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0 && visited[i][j]==false){
                    visited[i][j]=true;
                    for(int k=0;k<n;k++){
                        if(matrix[i][k]!=0 && visited[i][k]==false){
                            visited[i][k]=true;
                            matrix[i][k]=0;
                        }
                    }
                    for(int l=0;l<m;l++){
                        if(matrix[l][j]!=0 && visited[l][j]==false){
                            visited[l][j]=true;
                            matrix[l][j]=0;
                        }
                    }
                }
            }
        }

    }
}