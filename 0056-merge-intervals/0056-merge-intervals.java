class Solution {

    public int[][] merge(int[][] intervals) {
        int m=intervals.length;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int end=1;
        result.add(new ArrayList<>());
        result.get(0).add(intervals[0][0]);
        result.get(0).add(intervals[0][1]);
        while(end<m){
            if(result.get(result.size()-1).get(1)<intervals[end][0]){
                result.add(new ArrayList<>());
                result.get(result.size()-1).add(intervals[end][0]);
                result.get(result.size()-1).add(intervals[end][1]);
            }
            else{
                int tempStart=result.get(result.size()-1).get(0);
                int tempEnd=result.get(result.size()-1).get(1);
                result.remove(result.size()-1);
                result.add(new ArrayList<>());
                result.get(result.size()-1).add(tempStart);
                result.get(result.size()-1).add(Math.max(tempEnd,intervals[end][1]));
            }
            end++;
        }
                return result.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray())     .toArray(int[][]::new);

    }

    //easy to read approach with List<int []>
    /*
    public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}
    */
}