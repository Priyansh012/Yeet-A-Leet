class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Double.compare(a[0], b[0]));

        int left = points[0][0];
        int right = points[0][1];
        int intervals = 1;

        for(int i=1;i<points.length;i++){
            int curLeft=points[i][0];
            int curRight=points[i][1];

            if(curLeft>right){
                left=curLeft;
                right=curRight;
                intervals++;
            }
            else{
                right = Math.min(right, curRight);
            }
        }

        return intervals;

    }
}