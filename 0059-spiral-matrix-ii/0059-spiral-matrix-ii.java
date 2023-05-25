class Solution {
    public int[][] generateMatrix(int n) {
        int matrix [] [] = new int [n][n];
        int left=0, right=n-1, top=0,down=n-1;
        int direction=0,count=1;
        while(top<=down && left<=right){
            if(direction==0){
                for(int i=left;i<=right;i++){
                    matrix[top][i]=count++;
                }
                top+=1;
            }
            
            else if(direction==1){
                for(int i=top;i<=down;i++){
                    matrix[i][right]=count++;
                }
                right-=1;
            }
            
            else if(direction==2){
                for(int i=right;i>=left;i--){
                    matrix[down][i]=count++;
                }
                down-=1;
            }
            
            else if(direction==3){
                for(int i=down;i>=top;i--){
                    matrix[i][left]=count++;
                }
                left+=1;
            }
            
            direction=(direction+1)%4;
        }
        
        return matrix;
    }
}