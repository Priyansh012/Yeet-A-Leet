
class TweetCounts {

    private Map<String, List<Integer>> tweetMap;
    private Map<String, Integer> freqMap;

    public TweetCounts() {
        tweetMap = new HashMap();
        freqMap = new HashMap();
        freqMap.put("minute", 60);
        freqMap.put("hour", 3600);
        freqMap.put("day", 86400);
    }
    
    public void recordTweet(String tweetName, int time) {
        tweetMap.computeIfAbsent(tweetName, k -> new ArrayList()).add(time);
        Collections.sort(tweetMap.get(tweetName));
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {

        List<int[]> chunks = new ArrayList();
        List<Integer> result = new ArrayList();
        int timePeriod = freqMap.get(freq);
        int numberOfChunks = (int) Math.ceil((double)(endTime - startTime + 1) / (double) timePeriod);
        
        for(int i=0;i<numberOfChunks;i++){
            int end = Math.min(startTime + timePeriod - 1, endTime);
            chunks.add(new int[]{startTime, end});
            startTime = end + 1;
        }

        for(int[] chunk : chunks){
            int begin = chunk[0];
            int end = chunk[1];
            int pairs = 0;

            for(int timeStamp : tweetMap.get(tweetName)){

                if(timeStamp > end)
                    break;

                if(timeStamp >= begin && timeStamp <= end)
                    pairs++;
            }

            result.add(pairs);
        }

        return result;

    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */

