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

    //Binary search solution
    /*public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int start = 0, rows = matrix.length, cols = matrix[0].length;
            int end = rows * cols - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (matrix[mid / cols][mid % cols] == target) {
                    return true;
                } 
                if (matrix[mid / cols][mid % cols] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
        }*/
}