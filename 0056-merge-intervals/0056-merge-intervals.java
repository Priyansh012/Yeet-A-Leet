class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]==b[0]? Double.compare(a[1], b[1]): Double.compare(a[0], b[0]));

        Map<Integer, Integer> result = new TreeMap<>();
        int left=intervals[0][0];
        int right=intervals[0][1];
        int curLeft=0;
        int curRight=0;

        result.put(left, right);

        for(int i=1;i<intervals.length; i++){
            curLeft=intervals[i][0];
            curRight=intervals[i][1];

            if(curLeft<=right){
                right=Math.max(right, curRight);
                result.put(left, right);
            }
            else{
                left=curLeft;
                right=curRight;
                result.put(left,right);
            }
        }

        int ans [][] = new int [result.size()][2];
       int index = 0;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            ans[index][0] = entry.getKey();   
            ans[index][1] = entry.getValue();
            index++;
        }

        return ans;

    }
}