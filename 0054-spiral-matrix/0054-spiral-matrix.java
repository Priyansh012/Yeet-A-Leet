class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left=0,down=matrix.length-1,top=0,right=matrix[0].length-1;
        ArrayList<Integer> result= new ArrayList<Integer>();
        int direction=0;
        while(left<=right && top<=down){
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