class Solution {
    public int findChampion(int[][] grid) {
        int max=Integer.MIN_VALUE;
        int result=0;

        for(int i=0;i<grid.length;i++){
            int currentMax=0;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    currentMax+=1;
                }
            }

            if(max<currentMax){
                max=currentMax;
                result=i;
            }
        }

        return result;
    }
}