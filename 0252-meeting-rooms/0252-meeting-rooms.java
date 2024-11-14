class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length<1 || intervals.length==1)
            return true;
        
        Arrays.sort(intervals, (a,b) -> (a[0]==b[0])? Double.compare(a[1], b[1]): Double.compare(a[0], b[0]));

        int left=intervals[0][0];
        int right=intervals[0][1];
        int curLeft=0;
        int curRight=0;

        for(int i=1;i<intervals.length;i++){
             curLeft=intervals[i][0];
             curRight=intervals[i][1];

            if(curLeft<right){
                return false;
            }
            left=curLeft;
            right=curRight;
        }

        return true;
    }
}