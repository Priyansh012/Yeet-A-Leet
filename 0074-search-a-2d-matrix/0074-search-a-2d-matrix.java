class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;   

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(target>=matrix[i][j] && target<=matrix[i][n-1]){
                    while(j<n){
                        if(target==matrix[i][j]){
                            return true;
                        }
                        j++;
                    }
                }
                else{
                    break;
                }
            }
        }

        return false;
    }
}