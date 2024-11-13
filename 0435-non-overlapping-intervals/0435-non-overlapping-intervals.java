class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Double.compare(a[1], b[1]) : Double.compare(a[0], b[0]));
        
        int left = intervals[0][0];
        int right = intervals[0][1];
        int removalCount = 0;
        int curLeft = 0;
        int curRight = 0;

        for (int i = 1; i < intervals.length; i++) {
            curLeft = intervals[i][0];
            curRight = intervals[i][1];
            if (curLeft < right) {
                removalCount++;
                right=Math.min(right, curRight);
            } else {
                left = curLeft;
                right = curRight;
            }
        }

        return removalCount;
    }
}