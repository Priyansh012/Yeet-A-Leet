class Solution {
    //greedy solution use the most frequently occurred char first
    public String reorganizeString(String s) {
        Map<Character, Integer> countsMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for(char c: s.toCharArray()){
            countsMap.put(c, countsMap.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> countsMap.get(b)
        -countsMap.get(a));

        maxHeap.addAll(countsMap.keySet());

        while(maxHeap.size()>1){
            Character current = maxHeap.remove();
            Character next = maxHeap.remove();
            result.append(current);
            result.append(next);
            countsMap.put(current, countsMap.get(current)-1);
            countsMap.put(next, countsMap.get(next)-1);
            if(countsMap.get(current)>0)
                maxHeap.add(current);
            if(countsMap.get(next)>0)
                maxHeap.add(next);
        }

        while(!maxHeap.isEmpty()){
            char last=maxHeap.remove();
            if(countsMap.get(last)>1){
                return "";
            }

            result.append(last);
        }

        return result.toString();
    }
}