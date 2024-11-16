class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        
        for (int[] interval : intervals) {
            if (!endTimes.isEmpty() && endTimes.peek() <= interval[0]) {
                endTimes.poll(); 
            }
            // Add the current meeting's end time
            endTimes.add(interval[1]);
        }
        
        // The size of the priority queue indicates the number of rooms needed
        return endTimes.size();   
    }
}