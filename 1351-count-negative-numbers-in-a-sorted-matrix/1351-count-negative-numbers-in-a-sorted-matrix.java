class Solution {
    public int countNegatives(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            count+=binarySearch(0,n,grid[i]);
            
        }

        return count;
    }

    private int binarySearch(int left, int right, int array[]){
        int n=right;
        while(left<right){
            int mid=left+(right-left)/2;

            if(array[mid]>=0){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        System.out.println("inner count"+(n-right));
        return n-right;
    }
}